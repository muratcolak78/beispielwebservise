package com.bingoastradirectwebservice.model.astradirectmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class City {
	@JsonProperty("Id")
	private Long id;
	@JsonProperty("Zip")
	private String zip;
	@JsonProperty("City")
	private String city;
}
