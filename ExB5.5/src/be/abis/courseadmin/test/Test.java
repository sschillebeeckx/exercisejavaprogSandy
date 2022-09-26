package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.PriceException;
import be.abis.courseadmin.exception.PriceTooHighException;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class Test {

    public static void main(String[] args) {

        CompanyRepository cr = new MemoryArrayCompanyRepository();

        Course course1 = new Course("Java",5,500);
        Course course2 = new Course("SQL Fundamentals",2,450);
        Course course3 = new Course("TDD",2,450);

        Company comp1 = cr.findCompany(1);
        System.out.println(comp1);
        Company comp2 = cr.findCompany("smals");
        Company comp3 = cr.findCompany(4);

        Person p1 = new Person("Mary","Jones", Gender.FEMALE,comp1);
        Person p2=new Person("John","Doe",Gender.OTHER);
        Person p3 = new Person("Bob","Janssens", Gender.MALE,comp3);
        p1.addHobby("soccer");
        p2.addHobbies("gaming","walking","cooking");
        p3.addHobbies("soccer","dancing");

        System.out.println("\n------------------------ExB5.1 Price of CompanySession----------------------------------");
        CompanySession companySession1 = new CompanySession(course1,"5/10/2022",comp1,p1,comp2);
        companySession1.setNumberOfParticipants(2);
        CompanySession companySession2 = new CompanySession(course3,"7/11/2022",comp1,p3,comp2,5);

        Session[] sessions = {companySession1,companySession2};

        for (Session s:sessions){
            try {
                System.out.println("The price of " + s.getCourse() + " on " + s.getStartDate() + " is "  +s.calculatePrice() +".");
            } catch (PriceTooHighException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());
            } finally {
                System.out.println("printing an empty line after this one.\n");
            }
        }

        System.out.println("\n------------------------ExB5.5 Super Exception----------------------------------");

        try {
            double offer =comp2.requestPriceOfferForCompanySession(course2,1);
            //double offer =comp2.requestPriceOfferForCompanySession(course2,8);
            System.out.println("The price offer for  " + course2 +  " is "  +offer +".");
        } catch (PriceException e) {
            System.out.println(e.getMessage());
        }


    }
}
