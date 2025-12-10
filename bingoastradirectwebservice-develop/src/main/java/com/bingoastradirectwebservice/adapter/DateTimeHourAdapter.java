package com.bingoastradirectwebservice.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTimeHourAdapter extends XmlAdapter<String, Date> {
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T00:00'");

    @Override
    public Date unmarshal(String xml) throws Exception {
        return dateFormat.parse(xml);
    }

    @Override
    public String marshal(Date object) {
        return dateFormat.format(object);
    }
}