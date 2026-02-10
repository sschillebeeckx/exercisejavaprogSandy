package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class Test {

    public static void main(String[] args) {

        Course course1 = new Course("Java",5,500);
        Course course2 = new Course("SQL Fundamentals",2,450);
        Course course3 = new Course("TDD",2,450);

        CompanyRepository cr = new MemoryArrayCompanyRepository();

        Company comp1 = cr.findCompany(1);
       // System.out.println(comp1);
        Company comp2 = cr.findCompany("Smals");
        Company comp3 = cr.findCompany(4);

        Person p1 = new Person("Mary","Jones", Gender.FEMALE,comp1);
        Person p2 = new Person("John","Doe",Gender.OTHER);
        Person p3 = new Person("Bob","Janssens", Gender.MALE,comp3);
        p1.addHobby("soccer");
        p2.addHobbies("gaming","walking","cooking");
        p3.addHobbies("soccer","dancing");

        System.out.println("\n------------------------ExB4.12 Gender enum----------------------------------");
        Person[] persons = {p1,p2,p3};
        for (Person p: persons){
            p.printInfo();
            System.out.println();
        }

    }
}
