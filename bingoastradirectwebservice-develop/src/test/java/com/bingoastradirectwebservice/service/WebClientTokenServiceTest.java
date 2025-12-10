package com.allcompare.bingoastradirectwebservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class WebClientTokenServiceTest {

    @Mock
    private WebClientService webClientService;
    @InjectMocks
    private WebClientTokenService webClientTokenService;

    @Test
    void testUpdateToken_shouldCall_webClientPost() {

        assertThrows(NullPointerException.class, () -> {
            webClientTokenService.updateToken();
        });


        verify(webClientService, times(1)).performPost(any(), any(), any(), any(), any());
    }

    @Test
    void testGetToken_shouldReturn_Token() {

        String token = "BAERER = asdkjfhauhg";
        ReflectionTestUtils.setField(webClientTokenService, "token", token);

        String resultToken = webClientTokenService.getToken();

        assertEquals(token, resultToken);

    }

    @Test
    void testUpdateToken_shouldSet_tokenToResponse() {

        //Arrange
        String fakeAccessToken = "Baerer djfewukhfaifli232fu2wifi234th928fh";
        Mono<String> fakeMono = Mono.just("{\"access_token\": \"" + fakeAccessToken + "\"}");

        //Configure
        doReturn(fakeMono).when(webClientService).performPost(any(), any(), any(), any(), any());
        ReflectionTestUtils.setField(webClientTokenService, "tokenEndpoint", "tokenEndpoint");
        ReflectionTestUtils.setField(webClientTokenService, "user", "user");
        ReflectionTestUtils.setField(webClientTokenService, "password", "password");

        //Act
        webClientTokenService.updateToken();

        //Assert
        Assertions.assertEquals(fakeAccessToken, webClientTokenService.getToken());
    }

    @Test
    void testUpdateToken_shouldThrow_noTokenException() {

        //Arrange
        Mono<String> fakeMono = Mono.just("{\"noToken\": \"noToken\"}");

        //Configure
        doReturn(fakeMono).when(webClientService).performPost(any(), any(), any(), any(), any());
        ReflectionTestUtils.setField(webClientTokenService, "tokenEndpoint", "tokenEndpoint");
        ReflectionTestUtils.setField(webClientTokenService, "user", "user");
        ReflectionTestUtils.setField(webClientTokenService, "password", "password");

        Assertions.assertThrows(Exception.class, () -> webClientTokenService.getToken());
    }
}