package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void getterAndSetter_ShouldWorkCorrectly() {
        // Arrange
        Country country = new Country();
        String expectedCountryName = "Türkiye";
        Long expectedId = 1L;

        // Act
        country.setCountry(expectedCountryName);
        country.setId(expectedId);

        // Assert
        assertEquals(expectedCountryName, country.getCountry(), "Country name should match the set value");
        assertEquals(expectedId, country.getId(), "ID should match the set value");
    }

    @Test
    void allFields_ShouldBeSetViaSetters() {
        // Arrange
        String expectedCountryName = "Almanya";
        Long expectedId = 2L;
        Country country = new Country();

        // Act
        country.setCountry(expectedCountryName);
        country.setId(expectedId);

        // Assert
        assertEquals(expectedCountryName, country.getCountry(), "Country name should be set correctly via setter");
        assertEquals(expectedId, country.getId(), "ID should be set correctly via setter");
    }

    @Test
    void jsonPropertyAnnotations_ShouldNotAffectGetterSetterBehavior() {
        // Arrange
        Country country = new Country();
        String expectedCountryName = "Fransa";
        Long expectedId = 3L;

        // Act
        country.setCountry(expectedCountryName);
        country.setId(expectedId);

        // Assert
        assertEquals(expectedCountryName, country.getCountry(), "JsonProperty annotation should not break setter/getter");
        assertEquals(expectedId, country.getId(), "JsonProperty annotation should not break setter/getter");
    }
}