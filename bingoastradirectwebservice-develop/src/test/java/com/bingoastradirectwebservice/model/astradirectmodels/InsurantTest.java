package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsurantTest {

    // Primitive Type Tests
    @Test
    void getIdAndSetId_ShouldWorkCorrectly() {
        // Arrange
        Insurant insurant = new Insurant();
        long expectedId = 1001L;

        // Act
        insurant.setId(expectedId);
        long actualId = insurant.getId();

        // Assert
        assertEquals(expectedId, actualId, "ID getter/setter mismatch");
    }


    @Test
    void getInsuranceRankIdAndSetInsuranceRankId_ShouldWorkCorrectly() {
        // Arrange
        Insurant insurant = new Insurant();
        long expectedRankId = 80125L; // Plus

        // Act
        insurant.setInsuranceRankId(expectedRankId);
        long actualRankId = insurant.getInsuranceRankId();

        // Assert
        assertEquals(expectedRankId, actualRankId, "InsuranceRankId getter/setter mismatch");
    }

    @Test
    void getMissingTeethAndSetMissingTeeth_ShouldWorkCorrectly() {
        // Arrange
        Insurant insurant = new Insurant();
        int expectedTeeth = 2;

        // Act
        insurant.setMissingTeeth(expectedTeeth);
        int actualTeeth = insurant.getMissingTeeth();

        // Assert
        assertEquals(expectedTeeth, actualTeeth, "MissingTeeth getter/setter mismatch");
    }

    // Object Type Tests
    @Test
    void getFirstNameAndSetFirstName_ShouldWorkCorrectly() {
        // Arrange
        Insurant insurant = new Insurant();
        String expectedName = "Ahmet";

        // Act
        insurant.setFirstName(expectedName);
        String actualName = insurant.getFirstName();

        // Assert
        assertEquals(expectedName, actualName, "FirstName getter/setter mismatch");
    }

    @Test
    void getLastNameAndSetLastName_ShouldWorkCorrectly() {
        // Arrange
        Insurant insurant = new Insurant();
        String expectedName = "Yılmaz";

        // Act
        insurant.setLastName(expectedName);
        String actualName = insurant.getLastName();

        // Assert
        assertEquals(expectedName, actualName, "LastName getter/setter mismatch");
    }

    @Test
    void getDateOfBirthAndSetDateOfBirth_ShouldWorkCorrectly() {
        // Arrange
        Insurant insurant = new Insurant();
        String expectedDob = "15.05.1985";

        // Act
        insurant.setDateOfBirth(expectedDob);
        String actualDob = insurant.getDateOfBirth();

        // Assert
        assertEquals(expectedDob, actualDob, "DateOfBirth getter/setter mismatch");
    }

    @Test
    void getHealthInsuranceAndSetHealthInsurance_ShouldWorkCorrectly() {
        // Arrange
        Insurant insurant = new Insurant();
        String expectedInsurance = "SGK";

        // Act
        insurant.setHealthInsurance(expectedInsurance);
        String actualInsurance = insurant.getHealthInsurance();

        // Assert
        assertEquals(expectedInsurance, actualInsurance, "HealthInsurance getter/setter mismatch");
    }

    // Nullable Field Test
    @Test
    void getTitleIdAndSetTitleId_ShouldWorkCorrectly() {
        // Arrange
        Insurant insurant = new Insurant();
        Long expectedTitleId = 42L;

        // Act
        insurant.setTitleId(expectedTitleId);
        Long actualTitleId = insurant.getTitleId();

        // Assert
        assertEquals(expectedTitleId, actualTitleId, "TitleId getter/setter mismatch");
    }

    // Null Value Tests
    @Test
    void setters_ShouldAcceptNullValuesForNullableFields() {
        // Arrange
        Insurant insurant = new Insurant();

        // Act
        insurant.setFirstName(null);
        insurant.setLastName(null);
        insurant.setDateOfBirth(null);
        insurant.setHealthInsurance(null);
        insurant.setTitleId(null);

        // Assert
        assertAll("Nullable field checks",
            () -> assertNull(insurant.getFirstName()),
            () -> assertNull(insurant.getLastName()),
            () -> assertNull(insurant.getDateOfBirth()),
            () -> assertNull(insurant.getHealthInsurance()),
            () -> assertNull(insurant.getTitleId())
        );
    }
}