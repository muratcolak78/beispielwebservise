package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import com.allcompare.bingoastradirectwebservice.service.exceptionhandling.BaseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceRankTest {

    @ParameterizedTest
    @CsvSource({
            // tariffName, expectedId
            "zahnperfekt, 80211",
            "ZAHNPLUS,    80212",
            "  zahnmega  ,80213",

            "zahnplus,    80212",
            "ZAHNPERFEKT, 80211"
    })
    void testValidTariffNamesReturnCorrectIds(String tariffName, Long expectedId) {

        Long actualId = InsuranceRank.getIdByTariffName(tariffName);

        assertEquals(expectedId, actualId,
                () -> "Tarife adı '" + tariffName + "' için beklenen ID (" + expectedId + ") dönmedi.");
    }

    @Test
    void testInvalidTariffNameThrowsException() {
        String invalidName = "unknown";
        BaseException thrown = assertThrows(BaseException.class, () -> {
            InsuranceRank.getIdByTariffName(invalidName);
        });

        assertTrue(thrown.getMessage().contains("Unbekannte Versicherungsart"));
    }
}
