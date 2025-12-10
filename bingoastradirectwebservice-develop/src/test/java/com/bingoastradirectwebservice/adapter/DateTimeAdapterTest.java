package com.allcompare.bingoastradirectwebservice.adapter;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateTimeAdapterTest {

    @Test
    void testUnmarshal_shouldReturn_dateWithGivenInput() throws Exception {

        //Arrange
        DateTimeAdapter dateTimeAdapter = new DateTimeAdapter();
        String dateString = "2023-08-21";

        //Act
        Date date = dateTimeAdapter.unmarshal(dateString);

        //Assert
        assertNotNull(date);
    }

    @Test
    void testMarshal_shouldReturn_dateWithGivenInput() {

        //Arrange
        DateTimeAdapter dateTimeAdapter = new DateTimeAdapter();
        Date date = new Date();
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";

        //Act
        String resultString = dateTimeAdapter.marshal(date);
        Pattern pattern = Pattern.compile(regex);

        //Assert
        assertNotNull(resultString);
        Matcher matcher = pattern.matcher(resultString);
        assertTrue(matcher.matches());
    }
}
