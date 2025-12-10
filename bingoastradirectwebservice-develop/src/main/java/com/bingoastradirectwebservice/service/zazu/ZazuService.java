package com.bingoastradirectwebservice.service.zazu;

import com.bingoastradirectwebservice.model.Contract;
import com.bingoastradirectwebservice.model.ContractValue;
import com.bingoastradirectwebservice.model.astradirectmodels.*;

import com.bingoastradirectwebservice.service.exceptionhandling.*;
import com.bingoastradirectwebservice.utils.*;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import com.allcompare.bingoastradirectwebservice.service.zazu.ZazuClient;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
@RequiredArgsConstructor
@Setter
public class ZazuService {

    private final ZazuClient zazuClient;

    public void postPolicy(Contract contract) {
        try {
            processContract(contract);
        } catch (Exception e) {
            //log.error("Failed to post policy for contract {}: {}",
                    contract.getContractNumber(), e.getMessage(), e);
            throw new RuntimeException("Policy posting failed", e);
        }
    }

    private void processContract(Contract contract) {
        try {
            ContractValue contractValue = ContractValueMapper
                    .mappingContractValues(contract.getContractData().getValue());

            InsuranceRequest request = setRequest(contractValue, contract);

            String requestJson = JsonUtil.parseObjectToJson(request);
            log.debug("Request JSON: {}", requestJson);

            String response = zazuClient
                    .sendJsonRequestWithAuth(requestJson, String.class, true, contract)
                    .block();

            log.debug("Zazu API Response received for contract {}: {}",
                    contract.getContractNumber(), response);

            zazuClient.saveResponseStatus(requestJson, response, contract);

        } catch (BaseException e) {
            log.error("BaseException for contract {}: {}",
                    contract.getContractNumber(), e.getMessage(), e);
            handleBaseException(e, contract);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error for contract {}: {}",
                    contract.getContractNumber(), e.getMessage(), e);
            throw new RuntimeException("Error processing contract", e);
        }
    }

    private void handleBaseException(BaseException e, Contract contract) {
        String errorMessage = String.format(
                "Error processing contract %s: %s",
                contract.getContractNumber(),
                e.getMessage()
        );
        log.error(errorMessage);
    }


    public InsuranceRequest setRequest(ContractValue contractValue, Contract contract) {
        try {
            InsuranceRequest request = new InsuranceRequest();
            request.setTitle(getTitle(contractValue.getSalutation()));
            request.setCountry(getCountry());
            request.setInsurants(getInsurants(contractValue, contract));
            request.setInsuranceType(getInsurancetype(contract));
            request.setFirstName(contractValue.getFirstName());
            request.setLastName(contractValue.getLastName());
            request.setStreet(contractValue.getIpStreet());
            request.setZip(contractValue.getIpPostcode());
            request.setCity(contractValue.getIpCity());
            request.setPhone(contractValue.getIpTelefon());
            request.setEmail(contractValue.getEmail());
            request.setDateOfBirth(contractValue.getIpBirthdate());
            request.setAccountHolder(getAccountHolderName(contractValue));
            request.setIban(contractValue.getSepaBankIban());
            request.setBankCode(contractValue.getSepaBic());
            request.setNameOfBank(contractValue.getSepaBankName());
            String projectName = contract.getProject().getName();
            String company;
            if (projectName == null || projectName.trim().isEmpty()) {
                company = "allcompare";
            } else if ("verivox".equalsIgnoreCase(projectName.trim())) {
                company = "verivox";
            } else {
                company = "allcompare";
            }
            request.setCompany(company);
            request.setContractStart(contractValue.getContractBegin());
            request.setAgentNumber(contract.getBrokerNumber1());
            request.setProposalNumber(contract.getContractNumber());
            request.setLegalHealthInsurance(contractValue.getHealthinsurance());
            request.setInsurantsFamilyRelationship(getFamilyStatus(contractValue.getRealtedList()));
            request.setCreatedAt(DateTimeUtil.getNewDate2());

            return request;
        } catch (BaseException e) {

            log.warn("Fehler beim Erstellen des InsuranceRequest: {}", e.getMessage());
            catchErrorMessage(e);
            throw e;

        }
    }

    public boolean getFamilyStatus(String family) {
        if (family == null || family.trim().isEmpty()) {
            return false;
        }
        FamilyRelationship relationship = FamilyRelationship.fromDisplayName(family.trim());
        if (relationship == null) {
            return false;
        }
        return relationship.isCloseFamily();
    }


    public Title getTitle(String salutation) {
        Title title = new Title();
        validateField(salutation, "Anrede");
        switch (salutation.toLowerCase()) {
            case "herr":
                title.setId(1L);
                title.setDescription("Herr");
                break;
            case "frau":
                title.setId(2L);
                title.setDescription("Frau");
                break;
            default:
                throw new BaseException(new ErrorMessage(MessageType.INVALID_FORMAT_EXCEPTION, "Unbekannte Anrede: " + salutation));
        }
        return title;

    }

    public Country getCountry() {
        Country country = new Country();
        country.setId(1L);
        country.setCountry("Deutschland");
        return country;
    }

    public List<Insurant> getInsurants(ContractValue contractValue, Contract contract) {
        List<Insurant> insurants = new ArrayList<>();

        try {
            boolean isSelfInsured = "1".equals(contractValue.getQuestionSelfInsuredPerson());

            Insurant insurant;
            if (isSelfInsured) {
                insurant = buildInsurant(
                        true,
                        contractValue.getFirstName(),
                        contractValue.getLastName(),
                        contractValue.getIpBirthdate(),
                        getRankId(contract),
                        Integer.parseInt(contractValue.getMissingTooth()),
                        contractValue.getHealthinsurance(),
                        getTitle(contractValue.getSalutation()).getId()
                );
            } else {
                insurant = buildInsurant(
                        false,
                        contractValue.getLpForename(),
                        contractValue.getLpSurname(),
                        contractValue.getLpBirthdate(),
                        getRankId(contract),
                        Integer.parseInt(contractValue.getMissingTooth()),
                        contractValue.getLpHealthInsurance(),
                        getTitle(contractValue.getLpSalutation()).getId()
                );
            }

            insurants.add(insurant);
        } catch (BaseException e) {
            log.warn("Fehler beim Erstellen eine InsurantObjekt List: {}", e.getMessage());
            catchErrorMessage(e);
        }

        return insurants;
    }

    public Insurant buildInsurant(boolean isSelfInsured, String firstname, String lastname, String birthdate,
                                  Long insuranceRankId, int missingTeehth, String healthInsurance, Long titleId) {
        Insurant insurant = new Insurant();
        validateField(firstname, "Vorname");
        validateField(lastname, "Nachname");
        validateField(birthdate, "Geburtsdatum");

        if (insuranceRankId == null || insuranceRankId <= 0) {
            throw new BaseException(new ErrorMessage(MessageType.OUT_OF_RANGE_EXCEPTION, "Versicherungs-Rang-ID ist ungültig."));
        }

        if (missingTeehth < 0) {
            throw new BaseException(new ErrorMessage(MessageType.OUT_OF_RANGE_EXCEPTION, "Anzahl fehlender Zähne darf nicht negativ sein."));
        }

        if (titleId == null || titleId <= 0) {
            throw new BaseException(new ErrorMessage(MessageType.OUT_OF_RANGE_EXCEPTION, "Titel-ID ist ungültig."));
        }

        try {
            insurant.setId(0L);
            insurant.setFirstName(firstname);
            insurant.setLastName(lastname);
            insurant.setDateOfBirth(birthdate);
            insurant.setInsuree(isSelfInsured);
            insurant.setInsuranceRankId(insuranceRankId);
            insurant.setMissingTeeth(missingTeehth);
            insurant.setHealthInsurance(healthInsurance);
            insurant.setTitleId(titleId);
            return insurant;
        } catch (BaseException e) {
            log.warn("Fehler beim Erstellen eines Insurant-Objekts: {}", e.getMessage());
            catchErrorMessage(e);
            throw e;
        }
    }

    public InsuranceType getInsurancetype(Contract contract) {
        InsuranceType insuranceType = new InsuranceType();
        String tariffName = contract.getTariff().getName();
        validateField(tariffName, "Tariffname");
        String priceStr = contract.getPrice();
        validateField(priceStr, "Price");
        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            throw new BaseException(new ErrorMessage(MessageType.INVALID_FORMAT_EXCEPTION, "Price Format ist ungültig: " + priceStr));
        }
        try {
            insuranceType.setId(getInsuranceTypeId(tariffName));// >>>>> diese Stelle muss manuell geändert werden (sie sollte 19 oder 31 lauten) 2 wurde zu Testzwecken erstellt
            insuranceType.setName(tariffName);
            insuranceType.setSettlementPeriod(2);// 1 yearly 2 monthly
            insuranceType.setRankId(getRankId(contract));
            insuranceType.setInsuredPersonsMandatory(true);
            insuranceType.setPricePerSettlementPeriod(price);

            return insuranceType;

        } catch (BaseException e) {
            log.warn("Fehler beim Erstellen des InsuranceType : {}", e.getMessage());
            catchErrorMessage(e);
            throw e;
        }
    }

    public int getInsuranceTypeId(String tarifName) {
        return switch (tarifName.toLowerCase()) {
            case "zahnperfekt", "zahnplus", "zahnmega", "zahnsieger" -> 31;
            case "basis", "plus", "premium" -> 19;
            default -> 0;
        };
    }

    public Long getRankId(Contract contract) {
        return InsuranceRank.getIdByTariffName(contract.getTariff().getName());
    }

    public String getAccountHolderName(ContractValue contractValue) {
        boolean isOtherPerson = "1".equals(contractValue.getSepaBankOtherPersonQuestion());
        String name;

        if (isOtherPerson) {
            String forename = contractValue.getSepaBankOtherPersonForename();
            String surname = contractValue.getSepaBankOtherPersonSurname();
            validateField(forename, "SepaBankOtherPersonForename");
            validateField(surname, "SepaBankOtherPersonSurname");

            name = forename + " " + surname;
        } else {
            String firstName = contractValue.getFirstName();
            String lastName = contractValue.getLastName();

            validateField(firstName, "FirstName des Versicherungsnehmer");
            validateField(lastName, "LastName des Versicherungsnehmer");
            name = firstName + " " + lastName;
        }

        return name;
    }

    // helpers
    public void catchErrorMessage(BaseException e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        String errorPosition = "---> CLASS :" + stackTrace[0].getClassName() + " METHOD :" + stackTrace[0].getMethodName() + " LINE : " + stackTrace[0].getLineNumber();
        log.error("ERROR: {} {}", e.getMessage(), errorPosition);

    }

    private void validateField(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new BaseException(new ErrorMessage(MessageType.NULL_VALUE_EXCEPTION, fieldName + " darf nicht leer sein"));
        }
    }
}

