package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Country {
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Id")
    private Long id;

}
