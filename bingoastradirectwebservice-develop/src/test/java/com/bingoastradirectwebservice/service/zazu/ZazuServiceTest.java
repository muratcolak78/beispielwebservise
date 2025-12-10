package com.allcompare.bingoastradirectwebservice.service.zazu;

import com.allcompare.bingoastradirectwebservice.model.Contract;
import com.allcompare.bingoastradirectwebservice.model.ContractValue;
import com.allcompare.bingoastradirectwebservice.model.astradirectmodels.*;
import com.allcompare.bingoastradirectwebservice.utils.ContractValueMapper;
import com.allcompare.bingoastradirectwebservice.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-local.properties")
@ComponentScan(basePackages = "com.allcompare")
@RequiredArgsConstructor
class ZazuServiceTest {

    private Contract contract;
    private ContractValue contractValue;

    @Autowired
    private ZazuService zazuService;

    private String token;
    private InsuranceRequest request;

    @BeforeEach
    void init() throws IOException {

        String json = Files.readString(Paths.get("src/test/resources/ContractTestData.json"));
        contract = JsonUtil.parseJsonToObject(json, Contract.class);
        contractValue = ContractValueMapper.mappingContractValues(contract.getContractData().getValue());

        request = new InsuranceRequest();
    }

    @Test
    void setRequest_sollAlleFelderSetzen_undRequestZurückgeben() {
        // Arrange
        Title title = new Title();
        title.setDescription("Herr");
        request.setTitle(title);
        Country deutschland = new Country();
        deutschland.setCountry("Deutschland");
        request.setCountry(deutschland);
        request.setInsurants(List.of(new Insurant(), new Insurant()));
        request.setInsuranceType(new InsuranceType());
        request.setFirstName("Max");
        request.setLastName("Mustermann");
        request.setStreet("Beispielstraße 1");
        request.setZip("70173");
        request.setCity("Stuttgart");
        request.setPhone("017012345678");
        request.setEmail("max@example.com");
        request.setDateOfBirth("01.01.1978");
        request.setAccountHolder("Max Mustermann");
        request.setIban("DE00123456789012345678");
        request.setBankCode("GENODEF1S01");
        request.setNameOfBank("Volksbank");
        request.setCompany("testCompany");
        request.setContractStart("01.08.2025");
        request.setAgentNumber("V123456");
        request.setProposalNumber("20250717095842");
        request.setLegalHealthInsurance("testAOK");
        request.setInsurantsFamilyRelationship(true);
        request.setCreatedAt("17.07.2025 10:05:42");

        // Act & Assert
        Assertions.assertEquals("Herr", request.getTitle().getDescription());
        Assertions.assertEquals("Deutschland", request.getCountry().getCountry());
        Assertions.assertEquals(2, request.getInsurants().size());
        Assertions.assertNotNull(request.getInsuranceType());
        Assertions.assertEquals("Max", request.getFirstName());
        Assertions.assertEquals("Mustermann", request.getLastName());
        Assertions.assertEquals("Beispielstraße 1", request.getStreet());
        Assertions.assertEquals("70173", request.getZip());
        Assertions.assertEquals("Stuttgart", request.getCity());
        Assertions.assertEquals("017012345678", request.getPhone());
        Assertions.assertEquals("max@example.com", request.getEmail());
        Assertions.assertEquals("01.01.1978", request.getDateOfBirth());
        Assertions.assertEquals("Max Mustermann", request.getAccountHolder());
        Assertions.assertEquals("DE00123456789012345678", request.getIban());
        Assertions.assertEquals("GENODEF1S01", request.getBankCode());
        Assertions.assertEquals("Volksbank", request.getNameOfBank());
        Assertions.assertEquals("testCompany", request.getCompany());
        Assertions.assertEquals("01.08.2025", request.getContractStart());
        Assertions.assertEquals("V123456", request.getAgentNumber());
        Assertions.assertEquals("20250717095842", request.getProposalNumber());
        Assertions.assertEquals("testAOK", request.getLegalHealthInsurance());
        Assertions.assertTrue(request.isInsurantsFamilyRelationship());
        Assertions.assertEquals("17.07.2025 10:05:42", request.getCreatedAt());

        Assertions.assertNotNull(request);
    }

    @Test
    void getFamilyStatus_shouldReturnTrue_whenCloseFamily() {
        // Arrange
        String familyStatus = "Kind, Adoptiv- oder Pflegekind";

        // Act
        boolean isFamily = zazuService.getFamilyStatus(familyStatus);

        // Assert
        Assertions.assertTrue(isFamily);
    }

    @Test
    void getTitle_sollReturn_titleObject() {
        // Arrange
        String titleHerr = "Herr";
        String titleFrau = "Frau";

        // Act
        Title herr = zazuService.getTitle(titleHerr);
        Title frau = zazuService.getTitle(titleFrau);

        // Assert
        Assertions.assertEquals(titleHerr, herr.getDescription());
        Assertions.assertEquals(titleFrau, frau.getDescription());
    }

    @Test
    void getCountry_sollReturn_countryObject() {
        // Arrange
        String expectedCountry = "Deutschland";

        // Act
        String result = zazuService.getCountry().getCountry();

        // Assert
        Assertions.assertEquals(expectedCountry, result);
    }

    @Test
    void getInsurants_sollReturn_einInsurantslist() {
        // Act
        List<Insurant> expectedList = zazuService.getInsurants(contractValue, contract);
        // Assert
        Assertions.assertNotNull(expectedList);
    }

    @Test
    void getInsurant_sollReturn_einInsurantObject() {
        // Arrange
        String firstname = "testvorname";
        String lastname = "testnachname";
        String birthdate = "01.01.1980";
        Long insuranceRankId = 1L;
        int missingTeeth = 2;
        String healthInsurance = "gesetzlich";
        Long titleId = 2L;

        // Act
        Insurant result = zazuService.buildInsurant(true,firstname, lastname, birthdate, insuranceRankId, missingTeeth, healthInsurance, titleId);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0L, result.getId());
        Assertions.assertEquals(firstname, result.getFirstName());
        Assertions.assertEquals(lastname, result.getLastName());
        Assertions.assertEquals(birthdate, result.getDateOfBirth());
        Assertions.assertEquals(insuranceRankId, result.getInsuranceRankId());
        Assertions.assertEquals(missingTeeth, result.getMissingTeeth());
        Assertions.assertEquals(healthInsurance, result.getHealthInsurance());
        Assertions.assertEquals(titleId, result.getTitleId());
    }

    @Test
    void getInsurancetype_shouldReturnValidInsuranceTypeObject() {
        // Arrange
        /*
        Diese Daten sind bereits in der ContractTestData enthalten. das befindet sich
        src/test/resources/ContractTestData.json
        "price": 39.9,
        "name": "zahnperfekt",

        * */
        double expectedPrice = Double.parseDouble(contract.getPrice());
        String expectedName = contract.getTariff().getName();
        // Act
        InsuranceType result = zazuService.getInsurancetype(contract);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(31, result.getId());
        Assertions.assertEquals(expectedName, result.getName());
        Assertions.assertEquals(2, result.getSettlementPeriod());
        Assertions.assertEquals(zazuService.getRankId(contract), result.getRankId());
        Assertions.assertEquals(expectedPrice, result.getPricePerSettlementPeriod());
    }

    @Test
    void getInsuranceTypeId_sollReturnInsuranceTypeId() {
        //Arrange
        int expected = 31;
        //Act
        int result = zazuService.getInsuranceTypeId("zahnsieger");
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getRankId_sollReturnRankIdfromTariffsName() {
        //Arrange
        Long expected = 80211L;// weil das tarifname in ContractTestdata.json zahnperfect heißt
        //Act
        Long result = zazuService.getRankId(contract);
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAccountHolderName_sollReturn_nameOfAccountHolderFromContractData() {
        //Arrange
        String firstName = contractValue.getFirstName();// weil das tarifname in ContractTestdata.json zahnperfect heißt
        String lastName = contractValue.getLastName();
        String expected = firstName + " " + lastName;
        //Act
        String result = zazuService.getAccountHolderName(contractValue);
        //Assert
        Assertions.assertEquals(expected, result);
    }
}
