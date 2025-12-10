package com.allcompare.bingoastradirectwebservice.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@Slf4j
class ContractValueTest {

    private ContractValue contractValue;

    @BeforeEach
    void setUp() {
        contractValue = new ContractValue();
        contractValue.setId("123");
        contractValue.setContractBegin("2025-01-01");
        contractValue.setInsureGroup("Family");
        contractValue.setIpFamilyStatus("Married");
        contractValue.setSelectedTariffRetention("300");
        contractValue.setWayOfPayment("Monthly");
        contractValue.setMinimumDuration("24");
        contractValue.setTitle("Dr.");
        contractValue.setSalutation("Herr");
        contractValue.setFirstName("Max");
        contractValue.setLastName("Mustermann");
        contractValue.setIpBirthdate("01.01.1980");
        contractValue.setJob("Developer");
        contractValue.setQuestionSelfInsuredPerson("1");
        contractValue.setLpSalutation("Frau");
        contractValue.setLpSurname("Mustermann");
        contractValue.setLpForename("Maria");
        contractValue.setLpJob("Designer");
        contractValue.setLpHealthInsurance("AOK");
        contractValue.setRealtedList("Spouse");
        contractValue.setLpBirthdate("01.02.1982");
        contractValue.setLpTitle("Prof.");
        contractValue.setBirthdate("01.01.1980");
        contractValue.setTooth("0");
        contractValue.setToothPull("0");
        contractValue.setMissingTooth("0");
        contractValue.setInsureToothIncare("0");
        contractValue.setLooseProsthesis("0");
        contractValue.setFixedProsthesis("0");
        contractValue.setParodontoseEver("0");
        contractValue.setParodontoseCurrent("0");
        contractValue.setParodontose3y("0");
        contractValue.setBiteplane("0");
        contractValue.setBiteplane3y("0");
        contractValue.setIncare("0");
        contractValue.setKvInsurance("GKV");
        contractValue.setFilterAgeProvision("0");
        contractValue.setProsthesisAge("0");
        contractValue.setSinglecalculation("0");
        contractValue.setInsureToothCount("0");
        contractValue.setLeistung("Basic");
    }

    @Test
    void testGettersBasicInfo() {
        Assertions.assertEquals("123", contractValue.getId());
        Assertions.assertEquals("2025-01-01", contractValue.getContractBegin());
        Assertions.assertEquals("Family", contractValue.getInsureGroup());
        Assertions.assertEquals("Married", contractValue.getIpFamilyStatus());
        Assertions.assertEquals("300", contractValue.getSelectedTariffRetention());
        Assertions.assertEquals("Monthly", contractValue.getWayOfPayment());
        Assertions.assertEquals("24", contractValue.getMinimumDuration());
        Assertions.assertEquals("Dr.", contractValue.getTitle());
        Assertions.assertEquals("Herr", contractValue.getSalutation());
        Assertions.assertEquals("Max", contractValue.getFirstName());
        Assertions.assertEquals("Mustermann", contractValue.getLastName());
        Assertions.assertEquals("01.01.1980", contractValue.getIpBirthdate());
        Assertions.assertEquals("Developer", contractValue.getJob());
        Assertions.assertEquals("1", contractValue.getQuestionSelfInsuredPerson());
    }

    @Test
    void testGettersInsuredPersonAndDental() {
        Assertions.assertEquals("Frau", contractValue.getLpSalutation());
        Assertions.assertEquals("Mustermann", contractValue.getLpSurname());
        Assertions.assertEquals("Maria", contractValue.getLpForename());
        Assertions.assertEquals("Designer", contractValue.getLpJob());
        Assertions.assertEquals("AOK", contractValue.getLpHealthInsurance());
        Assertions.assertEquals("Spouse", contractValue.getRealtedList());
        Assertions.assertEquals("01.02.1982", contractValue.getLpBirthdate());
        Assertions.assertEquals("Prof.", contractValue.getLpTitle());
        Assertions.assertEquals("01.01.1980", contractValue.getBirthdate());
        Assertions.assertEquals("0", contractValue.getTooth());
        Assertions.assertEquals("0", contractValue.getToothPull());
        Assertions.assertEquals("0", contractValue.getMissingTooth());
        Assertions.assertEquals("0", contractValue.getInsureToothIncare());
        Assertions.assertEquals("0", contractValue.getLooseProsthesis());
        Assertions.assertEquals("0", contractValue.getFixedProsthesis());
    }

    @Test
    void testGettersInsuredPersonAndDental2() {
        Assertions.assertEquals("0", contractValue.getParodontoseEver());
        Assertions.assertEquals("0", contractValue.getParodontoseCurrent());
        Assertions.assertEquals("0", contractValue.getParodontose3y());
        Assertions.assertEquals("0", contractValue.getBiteplane());
        Assertions.assertEquals("0", contractValue.getBiteplane3y());
        Assertions.assertEquals("0", contractValue.getIncare());
        Assertions.assertEquals("GKV", contractValue.getKvInsurance());
        Assertions.assertEquals("0", contractValue.getFilterAgeProvision());
        Assertions.assertEquals("0", contractValue.getProsthesisAge());
        Assertions.assertEquals("0", contractValue.getSinglecalculation());
        Assertions.assertEquals("0", contractValue.getInsureToothCount());
        Assertions.assertEquals("Basic", contractValue.getLeistung());
    }

    @Test
    void testSettersAddressAndContact() {
        ContractValue contractValue5 = getContractValue();

        Assertions.assertEquals("Berlin", contractValue5.getIpCity());
        Assertions.assertEquals("42", contractValue5.getIpHousenumber());
        Assertions.assertEquals("Hauptstraße", contractValue5.getIpStreet());
        Assertions.assertEquals("030123456789", contractValue5.getIpTelefon());
        Assertions.assertEquals("10115", contractValue5.getIpPostcode());
        Assertions.assertEquals("test@example.com", contractValue5.getEmail());
        Assertions.assertEquals("0", contractValue5.getAllianzOtherInsurance());
        Assertions.assertEquals("0", contractValue5.getAllianzIncareYesNo());
        Assertions.assertEquals("0", contractValue5.getAllianzIncare());
        Assertions.assertEquals("0", contractValue5.getAllianzMissingTooth());
    }

    private static ContractValue getContractValue() {
        ContractValue contractValue = new ContractValue();

        contractValue.setIpCity("Berlin");
        contractValue.setIpHousenumber("42");
        contractValue.setIpStreet("Hauptstraße");
        contractValue.setIpTelefon("030123456789");
        contractValue.setIpPostcode("10115");
        contractValue.setEmail("test@example.com");
        contractValue.setAllianzOtherInsurance("0");
        contractValue.setAllianzIncareYesNo("0");
        contractValue.setAllianzIncare("0");
        contractValue.setAllianzMissingTooth("0");
        return contractValue;
    }

    @Test
    void testSettersBankAndEmployeeInfo() {
        ContractValue contractValue3 = getValue();

        Assertions.assertEquals("DE89370400440532013000", contractValue3.getSepaBankIban());
        Assertions.assertEquals("COBADEFFXXX", contractValue3.getSepaBic());
        Assertions.assertEquals("Commerzbank", contractValue3.getSepaBankName());
        Assertions.assertEquals("1", contractValue3.getSepaBankOtherPersonQuestion());
        Assertions.assertEquals("Herr", contractValue3.getSepaBankOtherPersonSalutation());
        Assertions.assertEquals("Schmidt", contractValue3.getSepaBankOtherPersonSurname());
        Assertions.assertEquals("Hans", contractValue3.getSepaBankOtherPersonForename());
        Assertions.assertEquals("01.03.1975", contractValue3.getSepaBankOtherPersonBirthdate());
        Assertions.assertEquals("1", contractValue3.getBankOtherAddressQuestion());
        Assertions.assertEquals("Hamburg", contractValue3.getBankOtherAddressCity());
        Assertions.assertEquals("20095", contractValue3.getBankOtherAddressPostcode());
        Assertions.assertEquals("Hafenstraße", contractValue3.getBankOtherAddressStreet());
        Assertions.assertEquals("10", contractValue3.getBankOtherAddressHousenumber());
        Assertions.assertEquals("1", contractValue3.getEmployeeDaimler());
        Assertions.assertEquals("Engineering", contractValue3.getEmployeeDaimlerDevision());
    }

    private static ContractValue getValue() {
        ContractValue contractValue = new ContractValue();

        contractValue.setSepaBankIban("DE89370400440532013000");
        contractValue.setSepaBic("COBADEFFXXX");
        contractValue.setSepaBankName("Commerzbank");
        contractValue.setSepaBankOtherPersonQuestion("1");
        contractValue.setSepaBankOtherPersonSalutation("Herr");
        contractValue.setSepaBankOtherPersonSurname("Schmidt");
        contractValue.setSepaBankOtherPersonForename("Hans");
        contractValue.setSepaBankOtherPersonBirthdate("01.03.1975");

        contractValue.setBankOtherAddressQuestion("1");
        contractValue.setBankOtherAddressCity("Hamburg");
        contractValue.setBankOtherAddressPostcode("20095");
        contractValue.setBankOtherAddressStreet("Hafenstraße");
        contractValue.setBankOtherAddressHousenumber("10");

        contractValue.setEmployeeDaimler("1");
        contractValue.setEmployeeDaimlerDevision("Engineering");
        return contractValue;
    }
}