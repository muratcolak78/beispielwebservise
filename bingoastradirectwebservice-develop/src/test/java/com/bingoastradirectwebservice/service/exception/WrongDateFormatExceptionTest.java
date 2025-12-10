package com.allcompare.bingoastradirectwebservice.service.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;


class WrongDateFormatExceptionTest {
    @Test
    void testWrongDateFormatException_shouldBe_notNull() {

        WrongDateFormatException exception = new WrongDateFormatException("Test");
        assertNotNull(exception);
    }

    @Test
    void testWrongDateFormatException_shouldContains_andReturn_givenMessage() {
        String errorMessage = "Test error message";
        WrongDateFormatException exception = new WrongDateFormatException(errorMessage);
        assertEquals(errorMessage, exception.getMessage(), errorMessage);
    }
}
