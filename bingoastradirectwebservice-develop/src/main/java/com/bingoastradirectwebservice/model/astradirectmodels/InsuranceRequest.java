package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class InsuranceRequest {
    @JsonProperty("Title")
    private com.allcompare.bingoastradirectwebservice.model.astradirectmodels.Title title;
    @JsonProperty("Firstname")
    private String firstName;
    @JsonProperty("Lastname")
    private String lastName;
    @JsonProperty("Street")
    private String street;
    @JsonProperty("ZIP")
    private String zip;
    @JsonProperty("City")
    private String city;
    @JsonProperty("Country")
    private Country country;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("SecondaryMailAddress")
    private String secondaryMailAddress;
    @JsonProperty("DateOfBirth")
    private String dateOfBirth; //dd.MM.yyyy
    @JsonProperty("AccountHolder")
    private String accountHolder;
    @JsonProperty("IBAN")
    private String iban;
    @JsonProperty("AccountNo")
    private String accountNo;
    @JsonProperty("BankCode")
    private String bankCode;
    @JsonProperty("NameOfBank")
    private String nameOfBank;
    @JsonProperty("InsuranceType")
    private com.allcompare.bingoastradirectwebservice.model.astradirectmodels.InsuranceType insuranceType;
    @JsonProperty("Components")
    private List<Component> components;
    @JsonProperty("ContractStart")
    private String contractStart; //dd.MM.yyyy
    @JsonProperty("Insurants")
    private List<com.allcompare.bingoastradirectwebservice.model.astradirectmodels.Insurant> insurants;
    @JsonProperty("Newsletter")
    private boolean newsLetter;
    @JsonProperty("Company")
    private String company;
    @JsonProperty("ProposalNumber")
    private String proposalNumber;//optional
    @JsonProperty("AgentNumber")
    private String agentNumber; //optional
    @JsonProperty("LegalHealthInsurance")
    private String legalHealthInsurance;
    @JsonProperty("InsurantsFamilyRelationship")
    private boolean insurantsFamilyRelationship;
    @JsonProperty("CreatedAt")
    private String createdAt;//dd.MM.yyyy HH:mm:ss
}
