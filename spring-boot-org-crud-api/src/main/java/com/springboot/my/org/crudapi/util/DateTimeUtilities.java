package com.springboot.my.org.crudapi.util;

import java.util.Date;

public class DateTimeUtilities {
private static Date date;
	
	private DateTimeUtilities() {
    }

    public static String getTimeStamp(){
        date = new Date();
        return date.toString();
    }
    public static Date getTime(){
        date = new Date();
        return date;
    }
}