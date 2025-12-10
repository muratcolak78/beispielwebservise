package com.allcompare.bingoastradirectwebservice.service.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;



class ApiPostExceptionTest {
	@Test
	void testApiPostException_shouldBe_notNull() {

		ApiPostException exception = new ApiPostException();
		assertNotNull(exception);
	}

}
