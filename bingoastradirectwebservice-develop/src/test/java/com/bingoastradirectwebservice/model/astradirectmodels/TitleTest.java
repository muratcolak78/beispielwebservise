package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TitleTest {

    @Test
    void getId_ShouldReturnSetValue() {
        // Arrange
        Title title = new Title();
        Long expectedId = 123L;
        
        // Act
        title.setId(expectedId);
        Long actualId = title.getId();
        
        // Assert
        assertEquals(expectedId, actualId, "ID getter should return the set value");
    }

    @Test
    void getDescription_ShouldReturnSetValue() {
        // Arrange
        Title title = new Title();
        String expectedDescription = "Backend Developer";
        
        // Act
        title.setDescription(expectedDescription);
        String actualDescription = title.getDescription();
        
        // Assert
        assertEquals(expectedDescription, actualDescription, "Description getter should return the set value");
    }

    @Test
    void setId_ShouldUpdateField() {
        // Arrange
        Title title = new Title();
        Long newId = 456L;
        
        // Act
        title.setId(newId);
        
        // Assert
        assertEquals(newId, title.getId(), "ID setter should update the field");
    }

    @Test
    void setDescription_ShouldUpdateField() {
        // Arrange
        Title title = new Title();
        String newDescription = "Frontend Developer";
        
        // Act
        title.setDescription(newDescription);
        
        // Assert
        assertEquals(newDescription, title.getDescription(), "Description setter should update the field");
    }
}