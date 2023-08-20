package com.indijanc.queryApp.utility;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ParseUtil {

    private static final List<String> dateTimeFormats = List.of(
            "MMM d, yyyy, h:mm:ss a",
            "MMM d, yyyy h:mm:ss a",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ss",
            "YYYY-MM-DDThh:mm:ss",
            "YYY-MM-DDThh:mm:ss.sss"
    );

    public static Double parseDoubleOrNull(String inputStr) {
        try {
            return Double.valueOf(inputStr);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }

    public static Integer parseIntOrNull(String inputStr) {
        try {
            return Integer.valueOf(inputStr);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }

    public static LocalDateTime parseDateTime(String inputStr) {
        LocalDateTime dateTime = null;
        for (String dateTimeFormat : dateTimeFormats) {
            try {
                dateTime = LocalDateTime.parse(inputStr, DateTimeFormatter.ofPattern(dateTimeFormat));
                break;
            }
            catch (DateTimeException ex) {
                if (dateTimeFormat.equals(dateTimeFormats.get(dateTimeFormats.size() - 1))) {
                    // Tried all formats, rethrow ...
                    throw ex;
                }
            }
        }
        return dateTime;
    }

    public static Boolean parseBoolean(String inputStr) {
        if (inputStr.equalsIgnoreCase("on") || inputStr.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        else if (inputStr.equalsIgnoreCase("off") || inputStr.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        else {
            throw new NumberFormatException("Unrecognized string representing boolean: " + inputStr);
        }
    }
}
