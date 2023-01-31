package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    Course c;

    @BeforeEach
    void setUp(){
        c = new Course("Java",5,500);
    }

    @Test
    void priceForJavaCourseIs2500(){
        double total = c.calculateTotalPrice();
        assertEquals(2500.0,total);
    }

    @Test
    void priceForJavaCourseWith10ReductionIs2250(){
        double total = c.calculateTotalPrice(10);
        assertEquals(2250.0,total);
    }

    @Test
    void toStringStartsWithTitle(){
        String s = c.toString();
        assertEquals("Title",s.substring(0,s.indexOf(" ")));
    }


}
