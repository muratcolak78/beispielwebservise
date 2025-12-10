package com.allcompare.bingoastradirectwebservice.service.exceptionhandling.handler;

import static org.assertj.core.api.Assertions.assertThat;

import com.allcompare.bingoastradirectwebservice.service.exceptionhandling.BaseException;
import com.allcompare.bingoastradirectwebservice.service.exceptionhandling.ErrorMessage;
import com.allcompare.bingoastradirectwebservice.service.exceptionhandling.MessageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
    }

    @Test
    void handlerBaseException_shouldReturnBadRequestWithFormattedMessage() {
        // Arrange
        ErrorMessage errorMessage = new ErrorMessage(MessageType.INVALID_FORMAT_EXCEPTION, "Falsches Format");
        BaseException ex = new BaseException(errorMessage);

        // Act
        ResponseEntity<String> response = handler.handlerBaseException(ex);

        // Assert
        String expectedMessage = errorMessage.prepareErrorMessage();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo(expectedMessage);
    }

    @Test
    void handlerBaseException_shouldReturnBadRequestWithMessageTypeOnlyWhenNoExtraMessage() {
        // Arrange
        ErrorMessage errorMessage = new ErrorMessage(MessageType.OUT_OF_RANGE_EXCEPTION, null);
        BaseException ex = new BaseException(errorMessage);

        // Act
        ResponseEntity<String> response = handler.handlerBaseException(ex);

        // Assert
        String expectedMessage = errorMessage.prepareErrorMessage();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo(expectedMessage);
    }
}
