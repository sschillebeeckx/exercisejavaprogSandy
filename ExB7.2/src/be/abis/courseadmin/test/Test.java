package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.exception.PriceException;
import be.abis.courseadmin.exception.PriceTooHighException;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;
import be.abis.courseadmin.util.DateUtils;
import be.abis.courseadmin.util.DecimalUtils;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {

        CompanyRepository cr = new MemoryListCompanyRepository();

        Course course1 = new Course("Java", 5, 500);
        Course course2 = new Course("SQL Fundamentals", 2, 450);
        Course course3 = new Course("TDD", 2, 450);

        try {
            Company comp1 = cr.findCompany(1);
            Company comp2 = cr.findCompany("smals");
            Company comp3 = cr.findCompany(4);

            Person p1 = new Person("Mary", "Jones", Gender.FEMALE, comp1);
            Person p2 = new Person("John", "Doe", Gender.OTHER, comp1);
            Person p3 = new Person("Bob", "Janssens", Gender.MALE, comp3);
            Person p4 = new Person("An", "Smets", Gender.FEMALE, comp2);
            Person p5 = new Person("Sam", "Smets", Gender.OTHER, comp2);
            Person p6 = new Person("Peter", "Vanroose", Gender.MALE, comp1);

            System.out.println("\n------------------------ExB4.8 Services abstract----------------------------------");
            CompanySession companySession1 = new CompanySession(course1, DateUtils.parse("05/3/2025"), comp1, p1, comp2);
            //companySession1.setNumberOfParticipants(5);
            CompanySession companySession2 = new CompanySession(course3, DateUtils.parse("7/4/2025"), comp1, p3, comp2, 5);
            PublicSession publicSession = new PublicSession(course2, LocalDate.of(2025,3,22), comp1, p3);

            Consultancy consultancy = new Consultancy();
            Service[] services = {companySession1, consultancy, companySession2, publicSession};
            for (Service s : services) {
                if (s instanceof Session) {
                    ((Session) s).printInfo();
                }
                try {
                    System.out.println("The price for the " + s.getClass().getSimpleName() + " is " + DecimalUtils.format(s.calculatePrice()/1.03) + ".\n");
                } catch (PriceTooHighException e) {
                    throw new RuntimeException(e);
                }

            }

            System.out.println("\n------------------------Exceptions----------------------------------");

            try {
                //double offer =comp2.requestPriceOfferForCompanySession(course2,1);
                double offer =comp2.requestPriceOfferForCompanySession(course2,8);
                System.out.println("The price offer for  " + course2 +  " is "  +offer +".");
            } catch (PriceException e) {
                System.out.println(e.getMessage());
            }

        } catch (CompanyNotFoundException cnf) {
            cnf.printStackTrace();
        }

    }
}
