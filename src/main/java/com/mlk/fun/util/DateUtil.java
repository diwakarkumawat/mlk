package com.mlk.fun.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    //String testDate = "29-Apr-2010,13:00:14 PM";
    static final DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");

    public static Date toDate(String input) {
        try {
            return formatter.parse(input);
        }catch(Exception x) {
            return new Date(); // for now - just return today
        }
    }
}
