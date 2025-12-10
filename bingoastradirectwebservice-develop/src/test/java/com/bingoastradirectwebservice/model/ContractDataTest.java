package com.allcompare.bingoastradirectwebservice.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;



class ContractDataTest {
	@Test
	void testGetAndSetUuid() {
		ContractData data = new ContractData();

		String uuid = "UUID_123";
		data.setUuid(uuid);

		assertEquals(uuid, data.getUuid());
	}

	@Test
	void testGetAndSetValue() {
		ContractData data = new ContractData();

		HashMap<String, Object> dataMap = new HashMap<>();
		dataMap.put("key1", "value1");
		dataMap.put("key2", 123);

		data.setValue(dataMap);

		assertEquals(dataMap, data.getValue());
	}

	@Test
	void testEquals_shouldReturn_true_withSameObjects() {

		ContractData contractDataOne = new ContractData();
		ContractData contractDataTwo = new ContractData();

		Assertions.assertEquals(contractDataOne, (contractDataTwo));
	}


	@Test
	void testHashCode_shouldSuccess_withTwoSameHashCodes() {

		ContractData contractDataOne = new ContractData();
		ContractData contractDataTwo = new ContractData();

		int hascodeOne = contractDataTwo.hashCode();
		int haschodeTwo = contractDataOne.hashCode();

		assertEquals(haschodeTwo, hascodeOne);
	}



	@Test
	void testEquals_shouldReturn_false_withNullValue() {

		//Arrange
		ContractData contractData = new ContractData();
		ContractData nullObject = null;

		//Act
		boolean result = contractData.equals(nullObject);

		//Assert
		assertFalse(result);
	}
}
