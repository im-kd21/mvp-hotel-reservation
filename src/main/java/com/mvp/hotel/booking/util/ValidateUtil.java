package com.mvp.hotel.booking.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidateUtil {

    public static boolean isValidDateFormat(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
