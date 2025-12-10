package com.allcompare.bingoastradirectwebservice.service.exceptionhandling;

public class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(ErrorMessage errorMessage) {

        super(errorMessage.prepareErrorMessage());
    }
}
