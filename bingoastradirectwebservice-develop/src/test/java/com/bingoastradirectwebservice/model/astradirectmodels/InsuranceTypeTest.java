package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsuranceTypeTest {

    // Boolean Fields
    @Test
    void booleanFields_ShouldGetSetCorrectly() {
        InsuranceType type = new InsuranceType();
        
        type.setAutoRenewal(true);
        type.setInsuredPersonsMandatory(false);
        
        assertAll("Boolean fields",
            () -> assertTrue(type.isAutoRenewal()),
            () -> assertFalse(type.isInsuredPersonsMandatory())
        );
    }

    // Numeric Fields
    @Test
    void numericFields_ShouldGetSetCorrectly() {
        InsuranceType type = new InsuranceType();
        
        type.setId(501);
        type.setSettlementPeriod(12);
        type.setAgeFrom(18);
        type.setAgeTo(65);
        
        assertAll("Numeric fields",
            () -> assertEquals(501, type.getId()),
            () -> assertEquals(12, type.getSettlementPeriod()),
            () -> assertEquals(18, type.getAgeFrom()),
            () -> assertEquals(65, type.getAgeTo())
        );
    }

    // Floating Point Field
    @Test
    void priceField_ShouldHandleDecimalValues() {
        InsuranceType type = new InsuranceType();
        
        type.setPricePerSettlementPeriod(249.99);
        
        assertEquals(249.99, type.getPricePerSettlementPeriod(), 0.001);
    }

    // String Field
    @Test
    void nameField_ShouldGetSetCorrectly() {
        InsuranceType type = new InsuranceType();
        
        type.setName("Gold Comprehensive");
        
        assertEquals("Gold Comprehensive", type.getName());
    }

    // Nullable Field
    @Test
    void rankId_ShouldHandleNull() {
        InsuranceType type = new InsuranceType();
        
        type.setRankId(null);
        
        assertNull(type.getRankId());
    }

    // Edge Cases
    @Test
    void shouldHandleMinMaxValues() {
        InsuranceType type = new InsuranceType();
        
        type.setId(Integer.MIN_VALUE);
        type.setPricePerSettlementPeriod(Double.MAX_VALUE);
        
        assertAll("Extreme values",
            () -> assertEquals(Integer.MIN_VALUE, type.getId()),
            () -> assertEquals(Double.MAX_VALUE, type.getPricePerSettlementPeriod())
        );
    }
}