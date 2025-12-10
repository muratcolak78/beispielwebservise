package com.bingoastradirectwebservice.util.exception;

import com.allcompare.bingoastradirectwebservice.utils.exception.ExtractXmlSectionException;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertTrue;


class ExtractXmlSectionExceptionTest {

	@Test
	void testConstructor_extractXmlSectionException_should_containGivenMessage() {

		String message = "Extraction failed";

		ExtractXmlSectionException exctractXmlException = new ExtractXmlSectionException(message);

		assertTrue(exctractXmlException.getMessage().contains(message));
	}

}
