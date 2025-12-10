package com.allcompare.bingoastradirectwebservice.testData.model;

import com.allcompare.bingoastradirectwebservice.model.ContractData;

import java.util.HashMap;
import java.util.UUID;

public class ContractDataTestData {

    public static ContractData setUpContractDataTestData() {

        ContractData contractData = new ContractData();
        contractData.setUuid(UUID.randomUUID().toString());
        HashMap<String, Object> dataMap1 = new HashMap<>();
        dataMap1.put("key1", "value1");
        dataMap1.put("key2", 123);
        contractData.setValue(dataMap1);

        return contractData;
    }
}
