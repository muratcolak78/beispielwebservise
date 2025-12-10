package com.allcompare.bingoastradirectwebservice.adapter;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DateTimeHourAdapterTest {

    @Test
    void testUnmarshal_shouldReturn_dateWithGivenInput() throws Exception {

        //Arrange
        DateTimeHourAdapter dateTimeHourAdapter = new DateTimeHourAdapter();
        String dateString = "2023-08-21T00:00";
        //Act
        Date date = dateTimeHourAdapter.unmarshal(dateString);

        //Assert
        assertNotNull(date);
    }

    @Test
    void testMarshal_shouldReturn_dateWithGivenInput() {

        //Arrange
        DateTimeHourAdapter dateTimeHourAdapter = new DateTimeHourAdapter();
        Date date = new Date();
        String regex = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}$";

        //Act
        String resultString = dateTimeHourAdapter.marshal(date);
        Pattern pattern = Pattern.compile(regex);

        //Assert
        assertNotNull(resultString);
        Matcher matcher = pattern.matcher(resultString);
        assertTrue(matcher.matches());
    }
}
