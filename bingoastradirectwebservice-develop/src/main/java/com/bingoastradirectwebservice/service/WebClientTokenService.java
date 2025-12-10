package com.allcompare.bingoastradirectwebservice.service;

import com.allcompare.bingoastradirectwebservice.service.exception.NoTokenException;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

@Service
@EnableScheduling
public class WebClientTokenService {
    private final WebClientService webClientService;
    private final WebClient webClientPolicy;
    private String token;
    @Value("${authentication.endpoint.token}")
    private String tokenEndpoint;
    @Value("${bingoApiGateway.user}")
    private String user;
    @Value("${bingoApiGateway.password}")
    private String password;


    public WebClientTokenService(WebClientService webClientService, WebClient webClientPolicy) {
        this.webClientService = webClientService;
        this.webClientPolicy = webClientPolicy;
    }

    /**
     * The "UpdateToken" method will run every 29 minutes, to receive a new token.
     */
    @Scheduled(fixedDelay = 1740000)
    public void updateToken() {
        String tokenString = "client_id=bingoApiGateway" +
                "&username=" + user +
                "&password=" + password +
                "&grant_type=password";

        Consumer<HttpHeaders> httpHeadersConsumer = httpHeaders -> httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        webClientService.performPost(webClientPolicy, tokenEndpoint, tokenString, String.class, httpHeadersConsumer).subscribe(jsonString -> {
            JSONObject jsonObject = new JSONObject(jsonString);

            if (jsonObject.has("access_token")) {
                token = jsonObject.getString("access_token");
            } else {
                token = null;
            }
        });
    }

    /**
     * Returns the current token and should be called by services that require the current bearer token.
     */

    public String getToken() {
        if (StringUtils.isBlank(token)) {
            updateToken();
        }
        if (StringUtils.isBlank(token)) {
            throw new NoTokenException("No token stored in WebClientTokenService. " + tokenEndpoint);
        }
        return token;
    }
}