package com.allcompare.bingoastradirectwebservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
class WebClientServiceTest {

    @InjectMocks
    private WebClientService webClientService;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;
    @Mock
    private WebClient.RequestBodySpec requestBodySpec;
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;
    @Mock
    private WebClient.ResponseSpec responseSpec;

    @Test
    void performPost_shouldReturnMonoOfType_whenResponseIsSuccessful() {
        // Arrange
        String path = "/dummy-url";
        DummyRequest dummyRequest = new DummyRequest("foo");
        DummyResponse dummyResponse = new DummyResponse("bar");

        // WebClient chain mocking
        Mockito.when(webClient.post()).thenReturn(requestBodyUriSpec);
        Mockito.when(requestBodyUriSpec.uri(path)).thenReturn(requestBodySpec);
        Mockito.when(requestBodySpec.headers(Mockito.any())).thenReturn(requestBodySpec);
        Mockito.when(requestBodySpec.bodyValue(dummyRequest)).thenReturn(requestHeadersSpec);
        Mockito.when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        Mockito.when(responseSpec.onStatus(Mockito.any(), Mockito.any())).thenReturn(responseSpec);
        Mockito.when(responseSpec.bodyToMono(DummyResponse.class)).thenReturn(Mono.just(dummyResponse));

        // Act
        Mono<DummyResponse> resultMono = webClientService.performPost(webClient, path, dummyRequest, DummyResponse.class, headers -> {
        });
        DummyResponse result = resultMono.block();

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals("bar", result.result);
    }

    // Dummy classes for test
    record DummyRequest(String value) {
    }

    record DummyResponse(String result) {
    }
}
