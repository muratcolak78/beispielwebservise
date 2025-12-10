package com.allcompare.bingoastradirectwebservice.service.exceptionhandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ErrorMessageTest {

    @Test
    void prepareErrorMessage_shouldReturnCorrectFormat_withExtraMessage() {
        ErrorMessage errorMessage = new ErrorMessage(MessageType.NULL_VALUE_EXCEPTION, "Feld darf nicht leer sein");
        String expected = "NULL_VALUE_EXCEPTION - Value darf nicht NULL sein : Feld darf nicht leer sein";

        assertEquals(expected, errorMessage.prepareErrorMessage());
    }

    @Test
    void prepareErrorMessage_shouldReturnCorrectFormat_withoutExtraMessage() {
        ErrorMessage errorMessage = new ErrorMessage(MessageType.OUT_OF_RANGE_EXCEPTION, null);
        String expected = "OUT_OF_RANGE_EXCEPTION - Value hat einen ungültigen Wert";

        assertEquals(expected, errorMessage.prepareErrorMessage());
    }
}
