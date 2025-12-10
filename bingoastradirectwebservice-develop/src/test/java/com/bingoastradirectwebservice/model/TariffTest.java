package com.allcompare.bingoastradirectwebservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


class TariffTest {

	@Test
	void testGettersAndSetters() {
		// Create an instance of Tariff
		Tariff tariff = new Tariff();

		// Set values using setters
		tariff.setUuid("123456789");
		tariff.setName("Basic Tariff");
		tariff.setSuffix("pre");
		tariff.setIdentifier("Medium");
		tariff.setTariffNameComplete("Axa Daimler - Basic Tariff");

		// Test getters
		Assertions.assertEquals("123456789", tariff.getUuid());
		Assertions.assertEquals("Basic Tariff", tariff.getName());
		Assertions.assertEquals("pre", tariff.getSuffix());
		Assertions.assertEquals("Medium", tariff.getIdentifier());
		Assertions.assertEquals("Axa Daimler - Basic Tariff", tariff.getTariffNameComplete());
	}

	@Test
	void testToString() {
		// Create an instance of Tariff
		Tariff tariff = new Tariff();
		tariff.setUuid("123456789");
		tariff.setName("Basic Tariff");
		tariff.setSuffix("pre");
		tariff.setIdentifier("basic");
		tariff.setTariffNameComplete("Axa Daimler - Basic Tariff");

		// Test toString method
		String expectedString = "Tariff{uuid='123456789', name='Basic Tariff', suffix='pre', identifier='basic', tariffNameComplete='Axa Daimler - Basic Tariff'}";
		Assertions.assertEquals(expectedString, tariff.toString());
	}

	@Test
	void testEqualsAndHashCode() {
		// Create two instances of Tariff with the same values
		Tariff tariff1 = new Tariff();
		tariff1.setUuid("123456789");
		tariff1.setName("Basic Tariff");
		tariff1.setSuffix("pre");
		tariff1.setIdentifier("basic");
		tariff1.setTariffNameComplete("Axa Daimler - Basic Tariff");

		Tariff tariff2 = new Tariff();
		tariff2.setUuid("123456789");
		tariff2.setName("Basic Tariff");
		tariff2.setSuffix("pre");
		tariff2.setIdentifier("basic");
		tariff2.setTariffNameComplete("Axa Daimler - Basic Tariff");

		// Test equals and hashCode methods
		Assertions.assertEquals(tariff1, tariff2);
		Assertions.assertEquals(tariff1.hashCode(), tariff2.hashCode());

		// Test (not) equals and hashCode methods
		tariff2.setIdentifier("medium");
		Assertions.assertNotEquals(tariff1, tariff2);
		Assertions.assertNotEquals(tariff1.hashCode(), tariff2.hashCode());
	}

	@Test
	void testEquals_shouldReturn_false_withNullValue() {

		//Arrange
		Tariff contractData = new Tariff();
		Tariff nullObject = null;

		//Act
		boolean result = contractData.equals(nullObject);

		//Assert
		assertFalse(result);
	}
}
