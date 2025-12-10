package com.allcompare.bingoastradirectwebservice.util.exception;

import com.allcompare.bingoastradirectwebservice.utils.exception.ParseXmlToStringException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;


class ParseXmlToStringExceptionTest {

	@Test
	void testConstructor_parseXmlToStringException_should_containGivenMessage() {

		String message = "Extraction failed";

		ParseXmlToStringException parseXmlToStringException = new ParseXmlToStringException(message);

		assertTrue(parseXmlToStringException.getMessage().contains(message));
	}
}
