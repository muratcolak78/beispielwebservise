package com.allcompare.bingoastradirectwebservice.service.exception;


public class CanceledByInsuranceCompanyException extends RuntimeException {
    public CanceledByInsuranceCompanyException(String message) {
        super(message);
    }

    public CanceledByInsuranceCompanyException(String message, Throwable cause) {
        super(message, cause);
    }
}
