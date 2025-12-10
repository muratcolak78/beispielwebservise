package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Insurant {
    @JsonProperty("Id")
    private long id;
    @JsonProperty("Firstname")
    private String firstName;
    @JsonProperty("Lastname")
    private String lastName;
    @JsonProperty("DateOfBirth")
    private String dateOfBirth; //dd.MM.yyyy
    @JsonProperty("IsInsuree")
    private boolean isInsuree;
    @JsonProperty("InsuranceRankId")
    private long insuranceRankId;// Basis=80124, Plus=80125, Premium=80126
    @JsonProperty("MissingTeeth")
    private int missingTeeth;
    @JsonProperty("HealthInsurance")
    private String healthInsurance;
    @JsonProperty("TitleId")
    private Long titleId ;

}
