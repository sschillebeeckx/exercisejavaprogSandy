package be.abis.courseadmin.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static LocalDate parse(String date){
        return LocalDate.parse(date,dtf);
    }

    public static String format(LocalDate date){
        return date.format(dtf);
    }
}
