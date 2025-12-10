package com.allcompare.bingoastradirectwebservice.model;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.assertTrue;



class ResponseStatusTest {

	@Test
	void testToString_shouldContain_propertiesAsString() {

		//Arrange
		ResponseStatus responseStatus = new ResponseStatus();
		String[] properties = {"contractId", "status", "endpointPath", "info"};

		//Act
		String responseStatusString = responseStatus.toString();

		//Iterate and Assert
		Iterator<String> valueJumper = Arrays.stream(properties).iterator();

		while (valueJumper.hasNext()) {
			assertTrue(responseStatusString.contains(valueJumper.next()));
		}
	}

	@Test
	void testEquals_shouldReturn_true_withSameObjects() {

		//Arrange
		ResponseStatus responseStatusOne = new ResponseStatus();
		ResponseStatus responseStatusTwo = new ResponseStatus();

		//Act
		boolean equality = responseStatusOne.equals(responseStatusTwo);

		//Assert
		assertTrue(equality);
	}

	@Test
	void testEquals_shouldReturn_true_withItself() {

		//Arrange
		ResponseStatus responseStatusOne = new ResponseStatus();

		//Act
		boolean equality = responseStatusOne.equals(responseStatusOne);

		//Assert
		assertTrue(equality);
	}
}