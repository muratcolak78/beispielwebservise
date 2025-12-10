package com.allcompare.bingoastradirectwebservice.service.zazu;

import com.allcompare.bingoastradirectwebservice.model.Contract;
import com.allcompare.bingoastradirectwebservice.model.ResponseStatus;
import com.allcompare.bingoastradirectwebservice.service.ResponseStatusService;
import com.allcompare.bingoastradirectwebservice.service.WebClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DisplayName("ZazuClient Unit Tests")
class ZazuClientTest {

    @Mock
    private ResponseStatusService responseStatusService;

    @Mock
    private WebClient webClientPolicy;

    @Mock
    private WebClient webClientPrice;

    @Mock
    private WebClientService webClientService;

    @InjectMocks
    private ZazuClient zazuClient;

    private Contract testContract;
    private String testRequestJson;
    private static final String API_BASE_URL = "https://api.test.com";
    private static final String API_ENDPOINT = "/v1/insurance";
    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPass";
    private static final String API_TOKEN = "testToken123";

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(zazuClient, "apiBaseUrl", API_BASE_URL);
        ReflectionTestUtils.setField(zazuClient, "apiEndPoint", API_ENDPOINT);
        ReflectionTestUtils.setField(zazuClient, "userName", USERNAME);
        ReflectionTestUtils.setField(zazuClient, "password", PASSWORD);
        ReflectionTestUtils.setField(zazuClient, "apiToken", API_TOKEN);

        testContract = createTestContract();
        testRequestJson = "{\"contractId\":\"123\",\"amount\":1000}";
    }

    @Test
    @DisplayName("Should handle API error and return error message")
    void shouldHandleApiError() {
        // Given
        String errorMessage = "Connection timeout";
        RuntimeException exception = new RuntimeException(errorMessage);

        when(webClientService.performPost(
                any(WebClient.class),
                anyString(),
                anyString(),
                eq(String.class),
                any(Consumer.class)
        )).thenReturn(Mono.error(exception));

        // When
        Mono<String> result = zazuClient.sendJsonRequestWithAuth(
                testRequestJson,
                String.class,
                true,
                testContract
        );

        // Then
        StepVerifier.create(result)
                .expectNext(errorMessage)
                .verifyComplete();
    }


    @Test
    @DisplayName("Should create correct authentication headers")
    void shouldCreateCorrectAuthHeaders() {
        // Given
        ArgumentCaptor<Consumer<HttpHeaders>> headersCaptor =
                ArgumentCaptor.forClass(Consumer.class);

        when(webClientService.performPost(
                any(WebClient.class),
                anyString(),
                anyString(),
                eq(String.class),
                headersCaptor.capture()
        )).thenReturn(Mono.just("response"));

        // When
        zazuClient.sendJsonRequestWithAuth(
                testRequestJson,
                String.class,
                true,
                testContract
        ).block();

        // Then
        Consumer<HttpHeaders> headersConsumer = headersCaptor.getValue();
        HttpHeaders headers = new HttpHeaders();
        headersConsumer.accept(headers);

        // Verify headers
        assertThat(headers.getContentType().toString())
                .isEqualTo("application/json");
        assertThat(headers.getFirst(HttpHeaders.AUTHORIZATION))
                .startsWith("Basic ");
        assertThat(headers.getFirst("APIToken"))
                .isEqualTo(API_TOKEN);
    }

    @Test
    @DisplayName("Should save failed response status")
    void shouldSaveFailedResponseStatus() {
        // Given
        String errorResponse = "Error: Invalid contract data";

        // When
        zazuClient.saveResponseStatus(testRequestJson, errorResponse, testContract);

        // Then
        verify(responseStatusService, times(1)).saveByMessagePathAndContractId(
                eq(ResponseStatus.Status.NOK),
                eq(testRequestJson),
                eq(errorResponse),
                eq("API returned error: " + errorResponse),
                eq(API_BASE_URL + API_ENDPOINT),
                eq(testContract.getId())
        );
    }

    @Test
    @DisplayName("Should handle null response")
    void shouldHandleNullResponse() {
        // Given
        String nullResponse = null;

        // When
        zazuClient.saveResponseStatus(testRequestJson, nullResponse, testContract);

        // Then
        verify(responseStatusService, times(1)).saveByMessagePathAndContractId(
                eq(ResponseStatus.Status.NOK),
                eq(testRequestJson),
                eq(nullResponse),
                contains("API returned error"),
                eq(API_BASE_URL + API_ENDPOINT),
                eq(testContract.getId())
        );
    }

    @Test
    @DisplayName("Should handle empty response")
    void shouldHandleEmptyResponse() {
        // Given
        String emptyResponse = "";

        // When
        zazuClient.saveResponseStatus(testRequestJson, emptyResponse, testContract);

        // Then
        verify(responseStatusService, times(1)).saveByMessagePathAndContractId(
                eq(ResponseStatus.Status.NOK),
                eq(testRequestJson),
                eq(emptyResponse),
                contains("API returned error"),
                eq(API_BASE_URL + API_ENDPOINT),
                eq(testContract.getId())
        );
    }

    @Test
    @DisplayName("Should handle whitespace-only response")
    void shouldHandleWhitespaceResponse() {
        // Given
        String whitespaceResponse = "   ";

        // When
        zazuClient.saveResponseStatus(testRequestJson, whitespaceResponse, testContract);

        // Then
        verify(responseStatusService, times(1)).saveByMessagePathAndContractId(
                eq(ResponseStatus.Status.NOK),
                any(),
                any(),
                contains("API returned error"),
                any(),
                any()
        );
    }


    @Test
    @DisplayName("Should handle exception during status save")
    void shouldHandleExceptionDuringStatusSave() {
        // Given
        String response = "123";
        doThrow(new RuntimeException("Database error"))
                .when(responseStatusService)
                .saveByMessagePathAndContractId(any(), any(), any(), any(), any(), any());

        // When & Then - should not throw exception
        zazuClient.saveResponseStatus(testRequestJson, response, testContract);

        // Verify the method was called despite exception
        verify(responseStatusService, times(1))
                .saveByMessagePathAndContractId(any(), any(), any(), any(), any(), any());
    }

    @Test
    @DisplayName("Should not save error status when isPolicyRequest is false")
    void shouldNotSaveErrorStatusForNonPolicyRequest() {
        // Given
        RuntimeException exception = new RuntimeException("API Error");

        when(webClientService.performPost(
                any(WebClient.class),
                anyString(),
                anyString(),
                eq(String.class),
                any(Consumer.class)
        )).thenReturn(Mono.error(exception));

        // When
        zazuClient.sendJsonRequestWithAuth(
                testRequestJson,
                String.class,
                false,  // ← isPolicyRequest = false
                testContract
        ).block();

        // Then - should NOT save error status
        verify(responseStatusService, never())
                .saveByMessagePathAndContractId(any(), any(), any(), any(), any(), any());
    }

    @Test
    @DisplayName("Should handle error with blank message")
    void shouldHandleErrorWithBlankMessage() {
        // Given
        RuntimeException exception = new RuntimeException("  "); // Blank message

        when(webClientService.performPost(
                any(WebClient.class),
                anyString(),
                anyString(),
                eq(String.class),
                any(Consumer.class)
        )).thenReturn(Mono.error(exception));

        // When
        zazuClient.sendJsonRequestWithAuth(
                testRequestJson,
                String.class,
                true,
                testContract
        ).block();

        // Then - should not save when message is blank
        verify(responseStatusService, never())
                .saveByMessagePathAndContractId(any(), any(), any(), any(), any(), any());
    }

    private Contract createTestContract() {
        Contract contract = new Contract();
        contract.setContractNumber("CT-2024-001");
        return contract;
    }
}