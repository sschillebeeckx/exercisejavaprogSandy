package be.abis.courseadmin.test;

import be.abis.courseadmin.exception.PriceException;
import be.abis.courseadmin.exception.PriceTooLowException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company;

    @BeforeEach
    public void setUp(){
         company = new Company("abis");
    }

    @Test
    void requestPriceOfferForCompanySessionAboutCourseJavaIs4000() throws PriceException {
        Course course = new Course("java",4,500);
        double price = company.requestPriceOfferForCompanySession(course,2);
        assertEquals(4000, price,0.01);
    }

    @Test
    void requestPriceOfferForCompanySessionAboutCourseIsTooLow()  {
        Course course = new Course("java",2,500);
        assertThrows(PriceTooLowException.class, ()-> company.requestPriceOfferForCompanySession(course,1));
    }

}