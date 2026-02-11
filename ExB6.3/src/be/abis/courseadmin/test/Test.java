package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        CompanyRepository cr = new MemoryListCompanyRepository();

        Course course1 = new Course("Java", 5, 500);
        Course course2 = new Course("SQL Fundamentals", 2, 450);
        Course course3 = new Course("TDD", 2, 450);

        System.out.println("\n------------------------ExB6.3 Enrolments----------------------------------");

        try {
            Company comp1 = cr.findCompany(1);
            Company comp2 = cr.findCompany("smals");
            Company comp3 = cr.findCompany(4);

            Person p1 = new Person("Mary","Jones", Gender.FEMALE,comp1);
            Person p2=new Person("John","Doe",Gender.OTHER);
            Person p3 = new Person("Bob","Janssens", Gender.MALE,comp3);
            Person p4 = new Person("An","Smets", Gender.FEMALE,comp2);
            Person p5 = new Person("Sam","Smets", Gender.OTHER,comp2);

            PublicSession publicSession = new PublicSession(course2,"22/3/2025",comp1,p1);

            publicSession.addEnrolment(p2);
            publicSession.addEnrolments(p4,p5);
            publicSession.addEnrolment(p3);
            publicSession.cancelEnrolment(p2);

            List<CourseParticipant> participants = publicSession.getEnrolments();
            System.out.println(participants);

        } catch (CompanyNotFoundException cnf) {
            cnf.printStackTrace();
        }


    }
}
