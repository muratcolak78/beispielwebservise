package com.allcompare.bingoastradirectwebservice.service.zazu;

import com.allcompare.bingoastradirectwebservice.model.Contract;
import com.allcompare.bingoastradirectwebservice.model.ResponseStatus;
import com.allcompare.bingoastradirectwebservice.service.ResponseStatusService;
import com.allcompare.bingoastradirectwebservice.service.WebClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

@Service
@Slf4j
@RequiredArgsConstructor
public class ZazuClient {

    @Value("${astradirect.api.host}")
    private String apiBaseUrl;

    @Value("${astradirect.api.endpoint}")
    private String apiEndPoint;

    @Value("${astradirect.username}")
    private String userName;

    @Value("${astradirect.password}")
    private String password;

    @Value("${astradirect.apitoken}")
    private String apiToken;

    private final ResponseStatusService responseStatusService;
    private final WebClient webClientPolicy;
    private final WebClient webClientPrice;
    private final WebClientService webClientService;


    public <T> Mono<T> sendJsonRequestWithAuth(
            String requestJson,
            Class<T> clazz,
            boolean isPolicyRequest,
            Contract contract) {

        String url = apiBaseUrl + apiEndPoint + "/ContractRequests";
        WebClient webClient = isPolicyRequest ? webClientPolicy : webClientPrice;

        log.debug("Sending JSON request to: {}", url);

        AtomicBoolean errorLogged = new AtomicBoolean(false);

        return webClientService.performPost(
                        webClient,
                        url,
                        requestJson,
                        clazz,
                        createAuthHeaders()
                )
                .subscribeOn(Schedulers.boundedElastic())
                .doOnError(error -> {
                    if (errorLogged.compareAndSet(false, true)) {
                        handleError(error, requestJson, isPolicyRequest, contract);
                    }
                })
                .onErrorResume(error -> {
                    log.error("Request failed, returning error message");
                    return Mono.just((T) error.getMessage());
                });
    }

    private Consumer<HttpHeaders> createAuthHeaders() {
        return httpHeaders -> {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            String auth = userName + ":" + password;
            String encodedAuth = Base64.getEncoder()
                    .encodeToString(auth.getBytes(StandardCharsets.UTF_8));
            httpHeaders.set(HttpHeaders.AUTHORIZATION, "Basic " + encodedAuth);

            httpHeaders.set("APIToken", apiToken);
        };
    }

    private void handleError(
            Throwable error,
            String requestJson,
            boolean isPolicyRequest,
            Contract contract) {

        if (StringUtils.isBlank(error.getMessage())) {
            log.warn("Error occurred but message is empty");
            return;
        }

        String errorMessage = String.format(
                "API request failed for contract %s: %s",
                contract.getContractNumber(),
                error.getMessage()
        );

        log.error(errorMessage);

        if (isPolicyRequest) {
            log.error("PostPolicy failed (API Error) for contract: {}",
                    contract.getContractNumber());

            saveErrorStatus(requestJson, error.getMessage(), contract);
        }
    }

    private void saveErrorStatus(String requestJson, String errorMessage, Contract contract) {
        try {
            responseStatusService.saveByMessagePathAndContractId(
                    ResponseStatus.Status.NOK,
                    requestJson,  // ← Request her zaman JSON
                    null,
                    errorMessage,
                    apiBaseUrl + apiEndPoint,
                    contract.getId()
            );
            log.debug("Error status saved for contract: {}", contract.getContractNumber());
        } catch (Exception e) {
            log.error("Failed to save error status: {}", e.getMessage(), e);
        }
    }

    public void saveResponseStatus(String requestJson, String response, Contract contract) {
        try {
            boolean isSuccess = isSuccessResponse(response);

            if (isSuccess) {
                saveSuccessStatus(requestJson, response, contract);
            } else {
                saveFailureStatus(requestJson, response, contract);
            }
        } catch (Exception e) {
            log.error("Failed to save response status for contract {}: {}",
                    contract.getContractNumber(), e.getMessage(), e);
        }
    }

    private void saveSuccessStatus(String requestJson, String response, Contract contract) {
        log.info("PostPolicy (ZAZU) successful for contract: {}", contract.getContractNumber());

        responseStatusService.saveByMessagePathAndContractId(
                ResponseStatus.Status.OK,
                requestJson,
                response,
                "Success",
                apiBaseUrl + apiEndPoint,
                contract.getId()
        );
    }


    private void saveFailureStatus(String requestJson, String response, Contract contract) {
        log.error("PostPolicy failed for contract: {}. Response: {}",
                contract.getContractNumber(), response);

        responseStatusService.saveByMessagePathAndContractId(
                ResponseStatus.Status.NOK,
                requestJson,
                response,
                "API returned error: " + response,
                apiBaseUrl + apiEndPoint,
                contract.getId()
        );
    }


    private boolean isSuccessResponse(String response) {
        if (StringUtils.isBlank(response)) {
            return false;
        }

        String trimmed = response.trim();

        try {
            int responseId = Integer.parseInt(trimmed);

            return responseId >= 100000 && responseId <= 999999;

        } catch (NumberFormatException e) {
            log.debug("Response is not a valid integer: {}", trimmed);
            return false;
        }
    }
}