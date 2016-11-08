package com.company.springmvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * Created by alt-hanny on 27.10.2016.
 */
public class DateHelper {

    private DateHelper() {
        super();
    }

    public static Date parseDate(String sdate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                Constants.OUTPUT_DATE_FORMAT);
        return new java.sql.Date(simpleDateFormat.parse(sdate).getTime());
    }

    public static Date parseFormDate(String sdate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                Constants.FORM_DATE_FORMAT);
        return new java.sql.Date(simpleDateFormat.parse(sdate).getTime());
    }

    public static String formatDate(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORM_DATE_FORMAT);
        return sdf.format(date);
    }

}

