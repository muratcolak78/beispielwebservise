package com.allcompare.bingoastradirectwebservice.service;

import com.allcompare.bingoastradirectwebservice.factory.ResponseStatusFactory;
import com.allcompare.bingoastradirectwebservice.model.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;
import java.util.function.Consumer;


@Validated
@Slf4j
@Service
public class ResponseStatusService {

    private final WebClientTokenService webClientTokenService;
    private final WebClientService webClientService;
    private final ResponseStatusFactory responseStatusFactory;
    private final WebClient webClientPolicy;

    @Value("${bingoApiGateway.host}")
    private String apiBaseUrl;

    public ResponseStatusService(WebClientTokenService webClientTokenService, WebClientService webClientService, ResponseStatusFactory responseStatusFactory, WebClient webClientPolicy) {
        this.webClientTokenService = webClientTokenService;
        this.webClientService = webClientService;
        this.responseStatusFactory = responseStatusFactory;
        this.webClientPolicy = webClientPolicy;
    }


    /**
     * Saves the given ResponseStatus Object asynchronously over the Api-Gateway.
     */
    public void sendPostRequest(ResponseStatus responseStatus) {

        Consumer<HttpHeaders> httpHeadersConsumer = httpHeaders -> {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer " + webClientTokenService.getToken());
        };
        webClientService.performPost(webClientPolicy, apiBaseUrl + "/responseStatus/save", responseStatus, String.class, httpHeadersConsumer).subscribe();
    }

    /**
     * Saves the ResponseStatus in any case that is possible (error or success)
     */

    public void saveByMessagePathAndContractId(ResponseStatus.Status status, String requestPayload, String responsePayload, String info, String path, UUID contractId) {

        sendPostRequest(responseStatusFactory.newResponseStatus(status, requestPayload, responsePayload, info, path, contractId));
    }
}