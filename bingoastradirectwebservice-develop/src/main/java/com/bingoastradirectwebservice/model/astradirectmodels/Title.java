package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Title {
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Id")
    private Long id;

}
