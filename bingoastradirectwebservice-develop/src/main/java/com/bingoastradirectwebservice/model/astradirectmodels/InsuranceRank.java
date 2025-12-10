package com.bingoastradirectwebservice.model.astradirectmodels;

import com.allcompare.bingoastradirectwebservice.service.exceptionhandling.BaseException;
import com.allcompare.bingoastradirectwebservice.service.exceptionhandling.ErrorMessage;
import com.allcompare.bingoastradirectwebservice.service.exceptionhandling.MessageType;

import java.util.Arrays;

public enum InsuranceRank {
    ZAHNPERFEKT(80211L, "zahnperfekt"),
    ZAHNPLUS(80212L, "zahnplus"),
    ZAHNMEGA(80213L, "zahnmega"),
    ZAHNSIEGER(80214L, "zahnsieger"),
    BASIS(80130L,"basis"),
    PLUS(80131L,"plus"),
    PREMIUM(80132L,"premium");

    private final Long id;
    private final String tariffName;

    InsuranceRank(Long id, String tariffName) {
        this.id = id;
        this.tariffName = tariffName;
    }

    public static Long getIdByTariffName(String name) {
        return Arrays.stream(values())
            .filter(rank -> rank.tariffName.equalsIgnoreCase(name.trim()))
            .findFirst()
            .map(InsuranceRank::getId)
            .orElseThrow(() -> new BaseException(
                new ErrorMessage(MessageType.INVALID_FORMAT_EXCEPTION,
                "Unbekannte Versicherungsart: " + name)
            ));
    }

    public Long getId() { return id; }
}