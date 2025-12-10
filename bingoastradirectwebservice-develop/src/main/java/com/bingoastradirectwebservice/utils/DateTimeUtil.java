package com.allcompare.bingoastradirectwebservice.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Slf4j
public class DateTimeUtil {

    /**
     * A private constructor is used to hide the public constructor since method calls are static.
     */
    private DateTimeUtil() {

    }

    public static String getNewDate2(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String nowFormatted = LocalDateTime.now().format(formatter);
        log.debug(nowFormatted);
        return nowFormatted;
    }
}
