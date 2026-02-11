package be.abis.courseadmin.test;

import be.abis.courseadmin.functional.Calculator;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.util.CalculatorUtils;
import be.abis.courseadmin.util.DecimalUtils;

public class Test {

    public static void main(String[] args) {

        System.out.println("\n------------------------ExB9.1 Price reduction via CalculatorUtils----------------------------------");

        Course course1 = new Course("SQL", 2, 475);
        System.out.println(DecimalUtils.format(course1.calculateTotalPrice(3)) );


        Calculator c = (d,i)-> d + d*i/100.;
        c.performCalculation(1000,9);

        CalculatorUtils.callCalculator((d,i)-> d + i, 1000,9);
    }
}
