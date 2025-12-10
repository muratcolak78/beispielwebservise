package com.allcompare.bingoastradirectwebservice.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.UUID;



class ContractTest {

	@Test
	void testGettersAndSetters() {
		Contract contract = new Contract();

		UUID randomUUID = UUID.randomUUID();

		InsuranceType insuranceType = new InsuranceType();
		Tariff tariff = new Tariff();
		ContractData contractData = new ContractData();

		contract.setId(randomUUID);
		contract.setContractNumber("900 12345678");
		contract.setInsuranceStart("1978-01-01");

		contract.setBrokerNumber1("BROKER123");
		contract.setInsuranceType(insuranceType);
		contract.setTariff(tariff);
		contract.setContractData(contractData);
		contract.setSignupTime("1978-01-01");

		Assertions.assertEquals(randomUUID, contract.getId());
		Assertions.assertEquals("900 12345678", contract.getContractNumber());
		Assertions.assertNotNull(contract.getInsuranceStart());

		Assertions.assertEquals("BROKER123", contract.getBrokerNumber1());
		Assertions.assertEquals(insuranceType, contract.getInsuranceType());
		Assertions.assertEquals(tariff, contract.getTariff());
		Assertions.assertEquals(contractData, contract.getContractData());
		Assertions.assertNotNull(contract.getSignupTime());
	}

	@Test
	void testEqualsAndHashCode() {
		Contract contract1 = new Contract();
		Contract contract2 = new Contract();

		UUID randomUUID = UUID.randomUUID();

		InsuranceType insuranceType = new InsuranceType();
		Tariff tariff = new Tariff();
		ContractData contractData = new ContractData();

		contract1.setId(randomUUID);
		contract1.setContractNumber("900 12345678");
		contract1.setInsuranceStart("1978-01-01");

		contract1.setBrokerNumber1("BROKER123");
		contract1.setInsuranceType(insuranceType);
		contract1.setTariff(tariff);
		contract1.setContractData(contractData);
		contract1.setSignupTime("1978-01-01");

		contract2.setId(randomUUID);
		contract2.setContractNumber("900 12345678");
		contract2.setInsuranceStart("1978-01-01");

		contract2.setBrokerNumber1("BROKER123");
		contract2.setInsuranceType(insuranceType);
		contract2.setTariff(tariff);
		contract2.setContractData(contractData);
		contract2.setSignupTime("1978-01-01");

		// Create another instance of Contract with different values
		Contract contract3 = new Contract();
		contract3.setId(UUID.randomUUID());
		contract3.setContractNumber("900 9876543");
		contract3.setInsuranceStart("1978-01-01");

		contract3.setBrokerNumber1("BROKER456");
		contract3.setInsuranceType(new InsuranceType());
		contract3.setTariff(new Tariff());
		contract3.setContractData(new ContractData());
		contract3.setSignupTime("1978-01-01");

		// Test if the two instances with the same values are equal
		Assertions.assertEquals(contract1, contract2);
		Assertions.assertEquals(contract1.hashCode(), contract2.hashCode());

		// Test if the instance with different values is not equal
		Assertions.assertNotEquals(contract1, contract3);
		Assertions.assertNotEquals(contract1.hashCode(), contract3.hashCode());
	}

}
