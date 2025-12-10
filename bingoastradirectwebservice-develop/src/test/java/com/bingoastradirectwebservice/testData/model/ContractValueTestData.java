package com.allcompare.bingoastradirectwebservice.testData.model;


import com.allcompare.bingoastradirectwebservice.model.ContractValue;



public class ContractValueTestData {

	public static ContractValue setUpContractValueTestData() {

		ContractValue contractValue = new ContractValue();
		contractValue.setSepaBankIban("SEPA_BANK_IBAN_123");
		contractValue.setInsureGroup("INSURE_GROUP_XYZ");
		contractValue.setFirstName("John");
		contractValue.setLastName("Doe");
		contractValue.setIpTelefon("123456789");
		contractValue.setEmail("john.doe@example.com");
		contractValue.setIpCity("New York");
		contractValue.setIpPostcode("10001");
		contractValue.setIpStreet("Main Street");
		contractValue.setIpHousenumber("123");
		contractValue.setWayOfPayment("PAYMENT_METHOD_1");

		return contractValue;
	}
}
