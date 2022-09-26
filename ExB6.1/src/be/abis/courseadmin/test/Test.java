package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class Test {

    public static void main(String[] args) {

        CompanyRepository cr = new MemoryArrayCompanyRepository();

        Course course1 = new Course("Java",5,500);
        Course course2 = new Course("SQL Fundamentals",2,450);
        Course course3 = new Course("TDD",2,450);

        try {
            Company comp1 = cr.findCompany(1);
            Company comp2 = cr.findCompany("smals");
            Company comp3 = cr.findCompany(4);

            Person p1 = new Person("Mary", "Jones", Gender.FEMALE, comp1);
            Person p2 = new Person("John", "Doe", Gender.OTHER);
            Person p3 = new Person("Bob", "Janssens", Gender.MALE, comp3);

            System.out.println("\n------------------------ExB6.1 Hobbies----------------------------------");
            p1.addHobby("soccer");
            p2.addHobbies("gaming", "walking", "cooking");
            p3.addHobbies("soccer", "dancing");

            p2.addHobby("gaming");

            Person[] persons = {p1, p2, p3};

            for (Person p : persons) {
                System.out.println(p + "'s hobbies are:");
                for (String hobby : p.getHobbies()) {
                    System.out.println(hobby);
                }
            }

        } catch (CompanyNotFoundException cnf){
            cnf.printStackTrace();
        }
    }
}
