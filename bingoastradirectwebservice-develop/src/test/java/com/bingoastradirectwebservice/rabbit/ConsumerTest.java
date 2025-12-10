package com.allcompare.bingoastradirectwebservice.rabbit;

import com.allcompare.bingoastradirectwebservice.service.zazu.ZazuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.amqp.core.MessageProperties;

import static org.mockito.Mockito.*;

class ConsumerTest {

    @Mock
    private ZazuService sdkservice;

    @InjectMocks
    private Consumer consumer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void receiveMessage_withUnknownMethod_shouldLogError() throws Exception {
        // Arrange
        String payloadJson = "{\"dummy\":\"data\"}";
        MessageProperties props = new MessageProperties();
        props.getHeaders().put("method", "unknownMethod");

        // Act
        consumer.receiveMessage("unknownMethod", payloadJson);

        // Assert
        verify(sdkservice, never()).postPolicy(any());
        verify(sdkservice, never()).catchErrorMessage(any());


    }

    @Test
    void receiveMessage_withPostPolicyMethod_shouldCallPostPolicy() throws Exception {
        // Arrange
        String payloadJson = "{\"contract\":\"data\"}";
        MessageProperties props = new MessageProperties();
        props.getHeaders().put("method", "postPolicy");

        // Act
        consumer.receiveMessage("postPolicy", payloadJson);

        // Assert
        verify(sdkservice, times(1)).postPolicy(any());
    }

}
