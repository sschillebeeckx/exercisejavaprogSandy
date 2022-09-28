package be.abis.courseadmin.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class DecimalUtils {

    static DecimalFormat setUpFormat(){
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator(',');
        otherSymbols.setGroupingSeparator('.');
        return new DecimalFormat("#,##0.00",otherSymbols);
    }


    public static String format(double d){
       DecimalFormat df = DecimalUtils.setUpFormat();
       return df.format(d);
    }
}
