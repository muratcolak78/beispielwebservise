package com.allcompare.bingoastradirectwebservice.service.exceptionhandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MessageTypeTest {

    @Test
    void getCodeAndMessage_shouldReturnCorrectValues() {
        MessageType type = MessageType.INVALID_FORMAT_EXCEPTION;

        assertEquals("2002", type.getCode());
        assertEquals("Value hat ein ungültiges Format", type.getMessage());
    }

    @Test
    void enumValues_shouldContainAllDefinedTypes() {
        MessageType[] values = MessageType.values();
        assertTrue(values.length >= 4);
    }
}
