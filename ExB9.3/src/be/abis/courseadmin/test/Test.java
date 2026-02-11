package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.FileCompanyRepository;
import be.abis.courseadmin.service.AbisEnrolmentService;
import be.abis.courseadmin.service.EnrolmentService;
import be.abis.courseadmin.util.DateUtils;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        CompanyRepository cr = new FileCompanyRepository();

        Course course2 = new Course("SQL Fundamentals", 2, 450);

        System.out.println("\n------------------------ExB6.3 Enrolments----------------------------------");

        try {
            Company comp1 = cr.findCompany(1);
            Company comp2 = cr.findCompany("smals");
            Company comp3 = cr.findCompany(4);

            Person p1 = new Person("Mary","Jones", Gender.FEMALE,comp1);
            Person p2 = new Person("John","Doe",Gender.OTHER);
            Person p3 = new Person("Bob","Janssens", Gender.MALE,comp3);
            Person p4 = new Person("Sam","Smets", Gender.FEMALE,comp2);
            Person p5 = new Person("An","Smets", Gender.OTHER,comp2);
            Person p6 = new Person("John","Smets", Gender.OTHER,comp2);

            PublicSession publicSession = new PublicSession(course2, DateUtils.parse("22/11/2022"),comp1,p1);
            publicSession.addEnrolments(p4,p6,p2, p3,p5);

            List<CourseParticipant> enrolments = publicSession.getEnrolments();


            System.out.println("\n------------------------ExB9.3 Full Participant List----------------------------------");
            System.out.println(enrolments);

            EnrolmentService es = new AbisEnrolmentService();

            System.out.println("\n------------------------ExB9.3  Participant List sorted on first name----------------------------------");
            System.out.println(es.sortParticipantsByFirstName(enrolments));

            System.out.println("\n------------------------ExB9.3  Participant List sorted on last name----------------------------------");
            System.out.println(es.sortParticipantsByLastName(enrolments));

            System.out.println("\n------------------------ExB9.3  Participant List sorted on last and first name----------------------------------");
            System.out.println(es.sortParticipantsByLastAndFirstName(enrolments));

        } catch (CompanyNotFoundException cnf) {
            cnf.printStackTrace();
        }
    }
}
