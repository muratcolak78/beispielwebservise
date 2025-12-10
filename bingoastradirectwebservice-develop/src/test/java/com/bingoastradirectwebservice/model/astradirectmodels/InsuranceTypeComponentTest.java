package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsuranceTypeComponentTest {

    @Test
    void getIdAndSetId_ShouldWorkCorrectly() {
        // Arrange
        InsuranceTypeComponent component = new InsuranceTypeComponent();
        int expectedId = 123;

        // Act
        component.setId(expectedId);
        int actualId = component.getId();

        // Assert
        assertEquals(expectedId, actualId, "ID should be set and retrieved correctly");
    }

    @Test
    void getNameAndSetName_ShouldWorkCorrectly() {
        // Arrange
        InsuranceTypeComponent component = new InsuranceTypeComponent();
        String expectedName = "Dental Coverage";

        // Act
        component.setName(expectedName);
        String actualName = component.getName();

        // Assert
        assertEquals(expectedName, actualName, "Name should be set and retrieved correctly");
    }

    @Test
    void setName_ShouldHandleNullValue() {
        // Arrange
        InsuranceTypeComponent component = new InsuranceTypeComponent();

        // Act
        component.setName(null);
        String actualName = component.getName();

        // Assert
        assertNull(actualName, "Name should accept null values");
    }
}