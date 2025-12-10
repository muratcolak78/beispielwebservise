package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InsuranceTypeComponent {
	@JsonProperty("Id")
	private int id;
	@JsonProperty("Name")
	private String name;

}
