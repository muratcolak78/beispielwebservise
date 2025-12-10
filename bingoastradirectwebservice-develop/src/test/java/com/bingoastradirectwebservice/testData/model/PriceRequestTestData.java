package com.allcompare.bingoastradirectwebservice.testData.model;

import com.allcompare.bingoastradirectwebservice.model.PriceRequest;

import java.util.ArrayList;

public class PriceRequestTestData {

	public static PriceRequest setUpPriceRequestTestData() {
		PriceRequest priceRequest = new PriceRequest();
		priceRequest.setTariffIdentifier("Compact");
		priceRequest.setQuestionList(new ArrayList<>());
		priceRequest.setInsuranceTypeName("insuranceTypeName");

		return priceRequest;
	}
}
