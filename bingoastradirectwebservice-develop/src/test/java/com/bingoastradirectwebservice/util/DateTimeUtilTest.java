package com.allcompare.bingoastradirectwebservice.util;

import com.allcompare.bingoastradirectwebservice.utils.DateTimeUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;


class DateTimeUtilTest {

    private static final String EXPECTED_FORMAT_REGEX =
            "\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}";

    private static final Pattern DATE_TIME_PATTERN = Pattern.compile(EXPECTED_FORMAT_REGEX);

    @Test
    void getNewDate2_shouldReturnStringInExpectedFormat() {
        String result = DateTimeUtil.getNewDate2();

        assertNotNull(result, "Meldung");

        assertTrue(DATE_TIME_PATTERN.matcher(result).matches(),
                "Meldung");

        assertEquals(19, result.length(), "Meldung");
    }

    @Test
    void constructor_shouldBePrivate() {
        final java.lang.reflect.Constructor<?>[] constructors = DateTimeUtil.class.getDeclaredConstructors();
        assertEquals(1, constructors.length, "Meldung");
        assertTrue(java.lang.reflect.Modifier.isPrivate(constructors[0].getModifiers()),
                "Meldung.");
    }
}