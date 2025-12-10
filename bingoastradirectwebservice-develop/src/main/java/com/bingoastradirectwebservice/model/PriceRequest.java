package com.bingoastradirectwebservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
public class PriceRequest {
    @NotEmpty
    private String tariffIdentifier;
    @NotEmpty
    private String insuranceTypeName;
    @NotEmpty
    private List<com.allcompare.bingoastradirectwebservice.model.Question> questionList;

}