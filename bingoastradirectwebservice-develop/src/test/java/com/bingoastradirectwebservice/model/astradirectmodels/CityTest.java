package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    void testGetterSetter() {
        //Arrange
        City city = new City();
        //Act
        city.setId(1L);
        city.setZip("12345");
        city.setCity("Berlin");
        //Assert
        assertEquals(1L, city.getId());
        assertEquals("12345", city.getZip());
        assertEquals("Berlin", city.getCity());
    }
}
