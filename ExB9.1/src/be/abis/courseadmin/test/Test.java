package be.abis.courseadmin.test;

import be.abis.courseadmin.functional.Calculator;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.util.DecimalUtils;

public class Test {

    public static void main(String[] args) {

        System.out.println("\n------------------------ExB9.1 Calculator tryout----------------------------------");

        Calculator c = (d, i) -> d*i;
        double result =c.performCalculation(5.2,3);
        System.out.println(DecimalUtils.format(result));

        System.out.println("\n------------------------ExB9.1 Price reduction----------------------------------");

        Course course1 = new Course("Java", 5, 500);
        System.out.println(DecimalUtils.format(course1.calculateTotalPrice(5)));




    }
}
