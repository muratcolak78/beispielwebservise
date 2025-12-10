package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InsuranceType {
    @JsonProperty("AutoRenewal")
    private boolean autoRenewal;
    @JsonProperty("Id")
    private int id;
    @JsonProperty("InsuredPersonsMandatory")
    private boolean insuredPersonsMandatory;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("PricePerSettlementPeriod")
    private double pricePerSettlementPeriod;
    @JsonProperty("SettlementPeriod")
    private int settlementPeriod;
    @JsonProperty("RankId")
    private Long rankId;
    @JsonProperty("AgeFrom")
    private Integer ageFrom;
    @JsonProperty("AgeTo")
    private Integer ageTo;


}
