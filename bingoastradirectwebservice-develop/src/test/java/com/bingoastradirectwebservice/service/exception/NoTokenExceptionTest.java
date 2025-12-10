package com.allcompare.bingoastradirectwebservice.service.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;



class NoTokenExceptionTest {

	@Test
	void testNoTokenException_shouldBe_notNull() {

		NoTokenException exception = new NoTokenException("TestMessage");
		assertNotNull(exception);
	}

	@Test
	void testNoTokenException_shouldContains_andReturn_givenMessage() {
		String errorMessage = "Test error message";
		NoTokenException exception = new NoTokenException(errorMessage);
		Assertions.assertEquals(errorMessage, exception.getMessage());
	}
}