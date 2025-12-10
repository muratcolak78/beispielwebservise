package com.allcompare.bingoastradirectwebservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class PriceItemTest {
    @Test
    void testAllGetterAndSetters_theyShouldReturn_sameAsInput() {
        // Arrange
        PriceItem priceItem = new PriceItem();
        double expectedPriceNative = 10.0;
        double expectedPrice = 200.0;

        // Act
        priceItem.setPriceNative(expectedPriceNative);
        priceItem.setPrice(expectedPrice);

        // Assert
        Assertions.assertEquals(expectedPriceNative, priceItem.getPriceNative(), 0.001);
        Assertions.assertEquals(expectedPrice, priceItem.getPrice(), 0.001);

    }

}
