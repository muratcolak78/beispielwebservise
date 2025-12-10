package com.allcompare.bingoastradirectwebservice.testData.model;

import com.allcompare.bingoastradirectwebservice.model.Contract;
import com.allcompare.bingoastradirectwebservice.model.ContractData;
import com.allcompare.bingoastradirectwebservice.model.InsuranceType;
import com.allcompare.bingoastradirectwebservice.model.Tariff;
import java.util.UUID;


public class ContractTestData {

	public static Contract setUpContractTestData() {

		Tariff tariff = new Tariff();
		ContractData contractData = ContractDataTestData.setUpContractDataTestData();
		InsuranceType insuranceType = new InsuranceType();

		Contract contract = new Contract();

		contract.setId(UUID.randomUUID());
		contract.setContractNumber("900 12345678");
		contract.setInsuranceStart("1978-01-01");
		contract.setBrokerNumber1("BROKER123");
		contract.setInsuranceType(insuranceType);
		contract.setTariff(tariff);
		contract.setContractData(contractData);
		contract.setSignupTime("1978-01-01");

		return contract;
	}
}
