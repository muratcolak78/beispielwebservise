package com.allcompare.bingoastradirectwebservice.service.exception;


public class PriceMismatchException extends Exception {

    public PriceMismatchException(String message) {
        super(message);
    }

    public PriceMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}