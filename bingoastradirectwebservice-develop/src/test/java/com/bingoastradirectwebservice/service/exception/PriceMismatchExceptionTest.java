package com.allcompare.bingoastradirectwebservice.service.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class PriceMismatchExceptionTest {
    @Test
    void testPriceMismatschException_shouldBe_notNUll() {
        //Arrange
        PriceMismatchException exception = new PriceMismatchException("test message");
        //Assert
        Assertions.assertNotNull(exception);
    }

    @Test
    void testPriceMismatschException_shouldContains_andReturn_givenMessage() {
        //Arrange
        String errorMessage = "Test error message";
        PriceMismatchException exception = new PriceMismatchException(errorMessage);
        //Assert
        Assertions.assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testPriceMismatchException_shouldContainMessageAndCause() {
        //Arrange
        String errorMessage = "Test error message";
        Throwable cause = new Throwable("Test cause");
        PriceMismatchException exception = new PriceMismatchException(errorMessage, cause);

        //Assert
        Assertions.assertEquals(errorMessage, exception.getMessage());
        Assertions.assertEquals(cause, exception.getCause());
    }


}
