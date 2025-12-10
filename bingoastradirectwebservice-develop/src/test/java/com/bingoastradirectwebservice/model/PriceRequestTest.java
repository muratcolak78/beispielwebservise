package com.allcompare.bingoastradirectwebservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;



class PriceRequestTest {
    @Test
    void testGetAndSetInsuranceTypeName_shouldReturn_sameAsInput() {

        String insuranceTypeName = "insuranceTypeName";

        PriceRequest contractValue = new PriceRequest();
        contractValue.setInsuranceTypeName(insuranceTypeName);

        Assertions.assertEquals(insuranceTypeName, contractValue.getInsuranceTypeName());
    }

    @Test
    void testGettersAndSetters() {
        // Create an instance of PriceRequest
        PriceRequest priceRequest = new PriceRequest();

        // Set values using setters
        priceRequest.setTariffIdentifier("TARIFF_123");

        List<Question> questionList = new ArrayList<>();
        Question question1 = new Question();
        question1.setReturnValue("TestReturn1");
        Question question2 = new Question();
        question2.setReturnValue("TestReturn2");
        questionList.add(question1);
        questionList.add(question2);
        priceRequest.setQuestionList(questionList);

        // Test getters
        Assertions.assertEquals("TARIFF_123", priceRequest.getTariffIdentifier());
        Assertions.assertEquals(questionList, priceRequest.getQuestionList());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two instances of PriceRequest with the same values
        PriceRequest priceRequest1 = new PriceRequest();
        priceRequest1.setTariffIdentifier("TARIFF_123");

        List<Question> questionList1 = new ArrayList<>();
        Question question1 = new Question();
        question1.setReturnValue("TestReturn1");
        Question question2 = new Question();
        question2.setReturnValue("TestReturn2");
        questionList1.add(question1);
        questionList1.add(question2);
        priceRequest1.setQuestionList(questionList1);

        PriceRequest priceRequest2 = new PriceRequest();
        priceRequest2.setTariffIdentifier("TARIFF_123");

        List<Question> questionList2 = new ArrayList<>();
        questionList2.add(question1);
        questionList2.add(question2);
        priceRequest2.setQuestionList(questionList2);

        // Test equals and hashCode methods
        Assertions.assertEquals(priceRequest1, priceRequest2);
        Assertions.assertEquals(priceRequest1.hashCode(), priceRequest2.hashCode());

        priceRequest2.setTariffIdentifier("Basic");
        Assertions.assertNotEquals(priceRequest1, priceRequest2);
        Assertions.assertNotEquals(priceRequest1.hashCode(), priceRequest2.hashCode());
    }
}
