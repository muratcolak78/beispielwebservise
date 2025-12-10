package com.bingoastradirectwebservice.config;

import io.netty.channel.ChannelOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.nio.charset.StandardCharsets;
import java.time.Duration;


@Slf4j
@Configuration
public class WebClientConfig {
    @Value("${webClient.maxBufferSize:2048}")
    private String bufferSize;

    @Bean
    public WebClient webClientPolicy() {
        return createWebClient(Duration.ofSeconds(40));
    }

    private WebClient createWebClient(Duration timeoutDuration) {
        int size = Integer.parseInt(bufferSize);
        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size * size))
                .build();

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(timeoutDuration)
                .compress(true); // Enable gzip decompression

        return WebClient.builder()
                .codecs(configure -> configure.defaultCodecs().enableLoggingRequestDetails(true))
                .exchangeStrategies(strategies)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .filter(acceptHeaderFilter())
                .filter((request, next) -> next.exchange(request)
                        .doOnNext(response -> {

                            if (!response.statusCode().is2xxSuccessful()) {
                                response.bodyToMono(String.class)
                                        .subscribe(body -> log.error("Error response body: {}", body));
                            }
                        }))
                .build();
    }

    private ExchangeFilterFunction acceptHeaderFilter() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            ClientRequest newRequest = ClientRequest.from(clientRequest)
                    .headers(headers -> headers.set(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name()))
                    .build();
            return Mono.just(newRequest);
        });
    }
}
