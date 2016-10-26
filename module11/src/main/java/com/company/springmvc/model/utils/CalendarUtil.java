package com.company.springmvc.model.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by alt-hanny on 27.10.2016.
 */

public class CalendarUtil {

    public static Date createStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date createEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static java.util.Date getTodayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());
        return calendar.getTime();
    }

    public static java.util.Date getTomorrowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());
        calendar.add(Calendar.HOUR, 24);
        return calendar.getTime();
    }
}

