package be.abis.courseadmin.util;

import be.abis.courseadmin.functional.Calculator;

public class CalculatorUtils {

    public static double callCalculator(Calculator c, double d, int i){
        return  c.performCalculation(d,i);
    }
}
