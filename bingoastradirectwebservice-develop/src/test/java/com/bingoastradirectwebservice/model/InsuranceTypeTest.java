package com.allcompare.bingoastradirectwebservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


class InsuranceTypeTest {

	@Test
	void testGettersAndSetters() {
		// Create an instance of InsuranceType
		InsuranceType insuranceType = new InsuranceType();

		// Set values using setters
		insuranceType.setUuid("UUID_123");
		insuranceType.setName("have");

		// Test getters
		Assertions.assertEquals("UUID_123", insuranceType.getUuid());
		Assertions.assertEquals("have", insuranceType.getName());
	}

	@Test
	void testToString() {
		// Create an instance of InsuranceType
		InsuranceType insuranceType = new InsuranceType();
		insuranceType.setUuid("UUID_123");
		insuranceType.setName("have");

		// Test toString method
		String expectedString = "InsuranceType{uuid='UUID_123', name='have'}";
		Assertions.assertEquals(expectedString, insuranceType.toString());
	}

	@Test
	void testEqualsAndHashCode() {
		// Create two instances of InsuranceType with the same values
		InsuranceType insuranceType1 = createInsuranceType("UUID_123", "have");
		InsuranceType insuranceType2 = createInsuranceType("UUID_123", "have");

		// Test equals method
		Assertions.assertEquals(insuranceType1, insuranceType2);
		Assertions.assertEquals(insuranceType2, insuranceType1);

		// Test hashCode method
		Assertions.assertEquals(insuranceType1.hashCode(), insuranceType2.hashCode());
	}

	@Test
	void testNotEquals() {
		// Create two instances of InsuranceType with different values
		InsuranceType insuranceType1 = createInsuranceType("UUID_123", "phve");
		InsuranceType insuranceType2 = createInsuranceType("UUID_456", "zazu");

		// Test equals method
		Assertions.assertNotEquals(insuranceType1, insuranceType2);
		Assertions.assertNotEquals(null, insuranceType1);
	}

	private InsuranceType createInsuranceType(String uuid, String name) {
		InsuranceType insuranceType = new InsuranceType();
		insuranceType.setUuid(uuid);
		insuranceType.setName(name);
		return insuranceType;
	}

	@Test
	void testEquals_shouldReturn_false_withNullValue() {

		//Arrange
		InsuranceType insuranceType = new InsuranceType();
		InsuranceType nullObject = null;

		//Act
		boolean result = insuranceType.equals(nullObject);

		//Assert
		assertFalse(result);
	}
}
