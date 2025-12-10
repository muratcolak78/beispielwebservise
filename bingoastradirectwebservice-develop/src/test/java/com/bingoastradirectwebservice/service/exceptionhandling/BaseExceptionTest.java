package com.allcompare.bingoastradirectwebservice.service.exceptionhandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BaseExceptionTest {

    @Test
    void constructor_shouldSetMessageFromErrorMessage() {
        ErrorMessage errorMessage = new ErrorMessage(MessageType.GENERAL_EXCEPTION, "Zusatzinfo");
        BaseException exception = new BaseException(errorMessage);

        String expectedMessage = errorMessage.prepareErrorMessage();
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void defaultConstructor_shouldCreateExceptionWithoutMessage() {
        BaseException exception = new BaseException();
        assertNull(exception.getMessage());
    }
}
