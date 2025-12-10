package com.allcompare.bingoastradirectwebservice.utils;

import com.allcompare.bingoastradirectwebservice.model.ContractValue;
import com.allcompare.bingoastradirectwebservice.model.PriceRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
public class ContractValueMapper {

    private ContractValueMapper() {
    }

    public static ContractValue mappingContractValues(Map<String, Object> payload) {
        return GenericDataMapper.mapFromPayload(payload, ContractValue.class);
    }

    public static ContractValue mappingContractValues(PriceRequest priceRequest) {
        return GenericDataMapper.mapFromPriceRequest(priceRequest, ContractValue.class);
    }
}
