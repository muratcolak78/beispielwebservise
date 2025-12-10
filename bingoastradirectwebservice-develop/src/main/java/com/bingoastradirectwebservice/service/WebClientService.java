package com.allcompare.bingoastradirectwebservice.service;

import com.allcompare.bingoastradirectwebservice.service.exception.ApiPostException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@Slf4j
@Service
public class WebClientService {
    public <T> Mono<T> performPost(WebClient client, String path, Object object, Class<T> clazz, Consumer<HttpHeaders> httpHeadersConsumer) {
        return client.post()
                .uri(path)
                .headers(httpHeadersConsumer)
                .bodyValue(object)
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError, error500 ->
                        error500.bodyToMono(String.class)
                                .flatMap(errorMessage -> Mono.error(new ApiPostException(errorMessage)))
                )
                .onStatus(HttpStatusCode::is4xxClientError, error400 ->
                        error400.bodyToMono(String.class)
                                .flatMap(errorMessage -> Mono.error(new ApiPostException(errorMessage)))
                )
                .bodyToMono(clazz);
    }
}


