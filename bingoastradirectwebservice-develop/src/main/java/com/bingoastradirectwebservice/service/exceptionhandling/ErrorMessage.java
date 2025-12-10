package com.allcompare.bingoastradirectwebservice.service.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private MessageType messageType;
    private String ofStatic; // extra message wird geschrieben kann.

    public String prepareErrorMessage() {
        StringBuilder errorMessageBuilder = new StringBuilder();
        errorMessageBuilder.append(getMessageType().name());
        errorMessageBuilder.append(" - ");
        errorMessageBuilder.append(getMessageType().getMessage());
        if (ofStatic != null) {
            errorMessageBuilder.append(" : " + ofStatic);
        }
        return errorMessageBuilder.toString();
    }
}