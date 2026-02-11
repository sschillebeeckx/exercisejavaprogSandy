package be.abis.courseadmin.test;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.model.PublicSession;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

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

            p1.addHobby("soccer");
            p2.addHobbies("gaming", "walking", "cooking");
            p3.addHobbies("soccer", "dancing");
            p4.addHobbies("arts","dancing");
            p5.addHobby("martial arts");

            PublicSession publicSession = new PublicSession(course2,"22/3/2025",comp1,p1);

            publicSession.addEnrolment(p2);
            publicSession.addEnrolments(p4,p5);
            publicSession.addEnrolment(p3);
            publicSession.cancelEnrolment(p2);

            System.out.println("\n------------------------ExB6.4 Participant List----------------------------------");

            publicSession.printParticipantList();

        } catch (CompanyNotFoundException cnf) {
            cnf.printStackTrace();
        }


    }
}
