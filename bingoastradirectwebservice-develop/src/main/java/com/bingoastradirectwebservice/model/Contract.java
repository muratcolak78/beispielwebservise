package com.bingoastradirectwebservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jetbrains.annotations.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contract {
    @NotNull
    private UUID id;
    private String contractNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy", timezone = "Europe/Berlin")
    private String insuranceStart;
    private String price;
    private String brokerNumber1;
    private com.allcompare.bingoastradirectwebservice.model.InsuranceType insuranceType;
    private com.allcompare.bingoastradirectwebservice.model.Project project;
    @NotNull
    private com.allcompare.bingoastradirectwebservice.model.Tariff tariff;
    @NotNull
    private com.allcompare.bingoastradirectwebservice.model.ContractData contractData;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Europe/Berlin")
    private String signupTime;
    private String wayOfPayment;
}

