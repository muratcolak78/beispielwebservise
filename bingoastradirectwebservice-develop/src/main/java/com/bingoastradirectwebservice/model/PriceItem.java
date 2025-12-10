package com.bingoastradirectwebservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Generated;


@Data
@Generated
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceItem {
    private double priceNative; // yearly netto
    private double price;
}