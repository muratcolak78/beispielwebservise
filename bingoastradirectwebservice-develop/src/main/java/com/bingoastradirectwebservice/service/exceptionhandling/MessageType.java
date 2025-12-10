package com.allcompare.bingoastradirectwebservice.service.exceptionhandling;

import lombok.Getter;


@Getter
public enum MessageType {
    // Allgemeine Fehler
    GENERAL_EXCEPTION("1000", "Ein unerwarteter Fehler ist aufgetreten."),

    // Fehlende Werte (Pflichtfeld wurde nicht ausgefüllt)
    NULL_VALUE_EXCEPTION("2001", "Value darf nicht NULL sein"),

    // Ungültiges Format (Wert entspricht nicht dem erwarteten Format)
    INVALID_FORMAT_EXCEPTION("2002", "Value hat ein ungültiges Format"),

    // Werte außerhalb des gültigen Bereichs
    OUT_OF_RANGE_EXCEPTION("2003", "Value hat einen ungültigen Wert");

    private final String code;
    private final String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}


