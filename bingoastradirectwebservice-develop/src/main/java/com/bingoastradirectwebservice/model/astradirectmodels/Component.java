package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Component {
    @JsonProperty("Id")
    private Long id;
    @JsonProperty("Name")
    private String name;

}
