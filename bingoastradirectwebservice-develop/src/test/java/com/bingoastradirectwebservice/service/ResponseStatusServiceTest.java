package com.allcompare.bingoastradirectwebservice.service;

import com.allcompare.bingoastradirectwebservice.factory.ResponseStatusFactory;
import com.allcompare.bingoastradirectwebservice.model.ResponseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.function.Consumer;

import static org.mockito.Mockito.*;

class ResponseStatusServiceTest {

    private WebClientTokenService tokenService;
    private WebClientService webClientService;
    private WebClient webClient;
    private ResponseStatusFactory responseStatusFactory;
    private ResponseStatusService responseStatusService;

    @BeforeEach
    void setup() {
        tokenService = mock(WebClientTokenService.class);
        webClientService = mock(WebClientService.class);
        webClient = mock(WebClient.class);
        responseStatusFactory=mock(ResponseStatusFactory.class);
        responseStatusService=mock(ResponseStatusService.class);


        responseStatusService = new ResponseStatusService(tokenService, webClientService,responseStatusFactory, webClient);

        when(tokenService.getToken()).thenReturn("mock-token");
        when(webClientService.performPost(any(), anyString(), any(), eq(String.class), any()))
                .thenReturn(Mono.just("dummy-response"));
    }


    @Test
    void shouldSendPostRequestWithTokenAndPayload() {
        // Arrange
        ResponseStatus status = new ResponseStatus();
        status.setStatus(ResponseStatus.Status.OK);
        status.setInfo("info");
        status.setContractId(UUID.randomUUID());

        when(tokenService.getToken()).thenReturn("mocked-token");

        // Act
        responseStatusService.sendPostRequest(status);

        // Assert
        verify(webClientService, times(1)).performPost(
                eq(webClient),
                contains("/responseStatus/save"),
                eq(status),
                eq(String.class),
                any(Consumer.class)
        );
    }

    @Test
    void shouldBuildAndSendResponseStatusFromFactory() {
        // Arrange
        ResponseStatus.Status statusEnum = ResponseStatus.Status.OK;
        String req = "req";
        String res = "res";
        String info = "extra";
        String path = "/x";
        UUID contractId = UUID.randomUUID();

        ResponseStatus builtStatus = new ResponseStatus();
        when(responseStatusFactory.newResponseStatus(statusEnum, req, res, info, path, contractId))
                .thenReturn(builtStatus);
        when(tokenService.getToken()).thenReturn("mocked-token");

        // Act
        responseStatusService.saveByMessagePathAndContractId(statusEnum, req, res, info, path, contractId);

        // Assert
        verify(responseStatusFactory).newResponseStatus(statusEnum, req, res, info, path, contractId);
        verify(webClientService).performPost(
                eq(webClient),
                contains("/responseStatus/save"),
                eq(builtStatus),
                eq(String.class),
                any(Consumer.class)
        );
    }
}
