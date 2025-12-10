package com.allcompare.bingoastradirectwebservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class InsuranceTest {


	@Test
	void testHashCode() {
		Insurance insurance1 = new Insurance();
		insurance1.setUuid("uuid1");
		insurance1.setName("Insurance Name");

		Insurance insurance2 = new Insurance();
		insurance2.setUuid("uuid1");
		insurance2.setName("Insurance Name");

		assertEquals(insurance1.hashCode(), insurance2.hashCode());
	}

	@Test
	void testEquals() {
		Insurance insurance1 = new Insurance();
		insurance1.setUuid("uuid1");
		insurance1.setName("Insurance Name");

		Insurance insurance2 = new Insurance();
		insurance2.setUuid("uuid1");
		insurance2.setName("Insurance Name");
		assertNotEquals(null, insurance2);
		assertEquals(insurance1, insurance2);
		assertEquals(insurance1, insurance2);
	}

	@Test
	void testToString() {
		Insurance insurance = new Insurance();
		insurance.setUuid("uuid1");
		insurance.setName("Insurance Name");

		String expectedToString = "Insurance{" +
				"uuid='uuid1', " +
				"name='Insurance Name'}";

		assertEquals(expectedToString, insurance.toString());
	}

	@Test
	void testGetterAndSetter() {
		Insurance insurance = new Insurance();
		// Set required fields for validation
		String uuid = "uuid1";
		String name = "name";
		insurance.setUuid(uuid);
		insurance.setName(name);

		Assertions.assertEquals(name, insurance.getName());
		Assertions.assertEquals(uuid, insurance.getUuid());
		// Validate the object
	}

	@Test
	void testEquals_shouldReturn_false_withNullValue() {

		//Arrange
		Insurance insurance = new Insurance();
		Insurance nullObject = null;

		//Act
		boolean result = insurance.equals(nullObject);

		//Assert
		assertFalse(result);
	}

	@Test
	void testEquals_shouldReturn_true_withSameObjects() {

		//Arrange
		Insurance insuranceTwo = new Insurance();

		//Act
		boolean resultOfEquality = insuranceTwo.equals(insuranceTwo);
		assertTrue(resultOfEquality);
	}
}
