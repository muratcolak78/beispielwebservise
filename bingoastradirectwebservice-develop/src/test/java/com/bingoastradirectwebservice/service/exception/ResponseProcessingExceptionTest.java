package com.allcompare.bingoastradirectwebservice.service.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;



class ResponseProcessingExceptionTest {

    @Test
    void testResponseProcessingException_shouldBe_notNull() {

        ResponseProcessingException exception = new ResponseProcessingException("TestMessage");
        assertNotNull(exception);
    }

    @Test
    void testResponseProcessingException_shouldContains_andReturn_givenMessage() {
        String errorMessage = "Test error message";
        ResponseProcessingException exception = new ResponseProcessingException(errorMessage);
        Assertions.assertEquals(errorMessage, exception.getMessage());
    }
}