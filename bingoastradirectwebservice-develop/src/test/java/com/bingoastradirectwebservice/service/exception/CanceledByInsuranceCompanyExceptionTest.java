package com.allcompare.bingoastradirectwebservice.service.exception;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;



class CanceledByInsuranceCompanyExceptionTest {

    @Test
    void testParametrizedConstructor() {
        String expectedMessage = "Insurance company canceled the policy.";

        CanceledByInsuranceCompanyException exception = new CanceledByInsuranceCompanyException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
        assertNull(exception.getCause());
    }
    @Test
    void testParametrizedConstructorWithCause() {
        String expectedMessage = "Insurance company canceled the policy.";
        Throwable expectedCause = new IllegalArgumentException("Invalid argument.");

        CanceledByInsuranceCompanyException exception = new CanceledByInsuranceCompanyException(expectedMessage, expectedCause);

        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(expectedCause, exception.getCause());
    }
}
