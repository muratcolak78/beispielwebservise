package com.allcompare.bingoastradirectwebservice.model.astradirectmodels;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InsuranceRequestTest {


    @Test
    void stringFields_ShouldGetSetCorrectly() {
        InsuranceRequest request = new InsuranceRequest();
        
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmail("john.doe@example.com");
        
        assertAll("String fields",
            () -> assertEquals("John", request.getFirstName()),
            () -> assertEquals("Doe", request.getLastName()),
            () -> assertEquals("john.doe@example.com", request.getEmail())
        );
    }


    @Test
    void dateFields_ShouldAcceptValidFormat() {
        InsuranceRequest request = new InsuranceRequest();
        
        request.setDateOfBirth("15.05.1985");
        request.setContractStart("01.01.2023");
        
        assertAll("Date fields",
            () -> assertEquals("15.05.1985", request.getDateOfBirth()),
            () -> assertEquals("01.01.2023", request.getContractStart())
        );
    }


    @Test
    void booleanFields_ShouldToggleCorrectly() {
        InsuranceRequest request = new InsuranceRequest();
        
        request.setNewsLetter(true);
        request.setInsurantsFamilyRelationship(false);
        
        assertAll("Boolean fields",
            () -> assertTrue(request.isNewsLetter()),
            () -> assertFalse(request.isInsurantsFamilyRelationship())
        );
    }


    @Test
    void objectFields_ShouldGetSet() {
        InsuranceRequest request = new InsuranceRequest();
        Title title = new Title();
        Country country = new Country();
        
        request.setTitle(title);
        request.setCountry(country);
        
        assertAll("Object fields",
            () -> assertEquals(title, request.getTitle()),
            () -> assertEquals(country, request.getCountry())
        );
    }


    @Test
    void listFields_ShouldHandleCollections() {
        InsuranceRequest request = new InsuranceRequest();
        List<Component> components = List.of(new Component());
        List<Insurant> insurants = List.of(new Insurant());
        
        request.setComponents(components);
        request.setInsurants(insurants);
        
        assertAll("List fields",
            () -> assertEquals(1, request.getComponents().size()),
            () -> assertEquals(1, request.getInsurants().size())
        );
    }


    @Test
    void financialFields_ShouldHandleFormats() {
        InsuranceRequest request = new InsuranceRequest();
        
        request.setIban("DE89370400440532013000");
        request.setBankCode("37040044");
        
        assertAll("Financial fields",
            () -> assertEquals("DE89370400440532013000", request.getIban()),
            () -> assertEquals("37040044", request.getBankCode())
        );
    }
}