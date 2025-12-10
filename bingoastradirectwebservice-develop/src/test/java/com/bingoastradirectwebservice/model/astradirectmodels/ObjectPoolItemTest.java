package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObjectPoolItemTest {

    // ID Field
    @Test
    void getIdAndSetId_ShouldWorkCorrectly() {
        // Arrange
        ObjectPoolItem item = new ObjectPoolItem();
        Long expectedId = 123L;

        // Act
        item.setId(expectedId);
        Long actualId = item.getId();

        // Assert
        assertEquals(expectedId, actualId, "ID getter/setter mismatch");
    }

    // Person Field
    @Test
    void getPersonAndSetPerson_ShouldWorkCorrectly() {
        // Arrange
        ObjectPoolItem item = new ObjectPoolItem();
        String expectedPerson = "John Doe";

        // Act
        item.setPerson(expectedPerson);
        String actualPerson = item.getPerson();

        // Assert
        assertEquals(expectedPerson, actualPerson, "Person getter/setter mismatch");
    }

    // ObjectDescription Field
    @Test
    void getObjectDescriptionAndSetObjectDescription_ShouldWorkCorrectly() {
        // Arrange
        ObjectPoolItem item = new ObjectPoolItem();
        String expectedDesc = "Laptop";

        // Act
        item.setObjectDescription(expectedDesc);
        String actualDesc = item.getObjectDescription();

        // Assert
        assertEquals(expectedDesc, actualDesc, "ObjectDescription getter/setter mismatch");
    }

    // ObjectDetail Field
    @Test
    void getObjectDetailAndSetObjectDetail_ShouldWorkCorrectly() {
        // Arrange
        ObjectPoolItem item = new ObjectPoolItem();
        String expectedDetail = "MacBook Pro 16-inch";

        // Act
        item.setObjectDetail(expectedDetail);
        String actualDetail = item.getObjectDetail();

        // Assert
        assertEquals(expectedDetail, actualDetail, "ObjectDetail getter/setter mismatch");
    }

    // ObjectValue Field
    @Test
    void getObjectValueAndSetObjectValue_ShouldWorkCorrectly() {
        // Arrange
        ObjectPoolItem item = new ObjectPoolItem();
        String expectedValue = "$2500";

        // Act
        item.setObjectValue(expectedValue);
        String actualValue = item.getObjectValue();

        // Assert
        assertEquals(expectedValue, actualValue, "ObjectValue getter/setter mismatch");
    }

    // Null Value Test
    @Test
    void setters_ShouldAcceptNullValues() {
        // Arrange
        ObjectPoolItem item = new ObjectPoolItem();

        // Act
        item.setId(null);
        item.setPerson(null);
        item.setObjectDescription(null);
        item.setObjectDetail(null);
        item.setObjectValue(null);

        // Assert
        assertAll("Null value checks",
            () -> assertNull(item.getId()),
            () -> assertNull(item.getPerson()),
            () -> assertNull(item.getObjectDescription()),
            () -> assertNull(item.getObjectDetail()),
            () -> assertNull(item.getObjectValue())
        );
    }
}