package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComponentTest {

    @Test
    void testGetterSetter() {
        Component component = new Component();

        component.setId(10L);
        component.setName("Processor");

        assertEquals(10L, component.getId());
        assertEquals("Processor", component.getName());
    }
}
