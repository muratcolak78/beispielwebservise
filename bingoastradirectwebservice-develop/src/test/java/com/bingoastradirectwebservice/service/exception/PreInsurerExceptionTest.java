package com.allcompare.bingoastradirectwebservice.service.exception;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;



class PreInsurerExceptionTest {
    @Test
    void testWrongDateFormatException_shouldBe_notNull() {

        PreInsurerException exception = new PreInsurerException("Test");
        assertNotNull(exception);
    }

    @Test
    void testWrongDateFormatException_shouldContains_andReturn_givenMessage() {
        String errorMessage = "Test error message";
        PreInsurerException exception = new PreInsurerException(errorMessage);
        assertEquals(errorMessage, exception.getMessage(), errorMessage);
    }
}
