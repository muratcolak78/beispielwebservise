package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ObjectPoolItem {
    @JsonProperty("Id")
    private Long id;
    @JsonProperty("Person")
    private String person;
    @JsonProperty("ObjectDescription")
    private String objectDescription;
    @JsonProperty("ObjectDetail")
    private String objectDetail;
    @JsonProperty("ObjectValue")
    private String objectValue  ;
}
