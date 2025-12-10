package com.allcompare.bingoastradirectwebservice.testData.model;

import com.allcompare.bingoastradirectwebservice.model.ResponseStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ResponseStatusTestData {

	public static ResponseStatus setUpResponseStatus() {
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setStatus(ResponseStatus.Status.OK);
		responseStatus.setCreatedDate(new Date());
		responseStatus.setContractId(UUID.randomUUID());
		responseStatus.setCreatedUser("webServiceUser");
		responseStatus.setEndpointPath("postPolicy Successful");
		return responseStatus;
	}

	public static List<ResponseStatus> setUpResponseStatusList() {

		List<ResponseStatus> responseStatusList = new ArrayList<>();

		responseStatusList.add(setUpResponseStatus());
		responseStatusList.add(setUpResponseStatus());
		responseStatusList.add(setUpResponseStatus());

		return responseStatusList;
	}
}
