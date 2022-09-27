package be.abis.courseadmin.util;

import java.text.DecimalFormat;

public class DecimalUtils {

    static DecimalFormat df = new DecimalFormat("#,##0.00");

    public static String format(double d){
       return df.format(d);
    }
}
