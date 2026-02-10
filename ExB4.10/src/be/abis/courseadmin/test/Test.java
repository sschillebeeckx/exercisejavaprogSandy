package be.abis.courseadmin.test;

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
        Company comp2 = cr.findCompany("Smals" );
        Company comp3 = cr.findCompany(4);

        Person p1 = new Person("Mary","Jones",comp1);
        Person p2 = new Person("John","Doe");
        Person p3 = new Person("Bob","Janssens",comp3);


        System.out.println("\n------------------------ExB4.8 Services abstract----------------------------------");
        CompanySession companySession1 = new CompanySession(course1,"5/3/2025",comp1,p1,comp2);
        CompanySession companySession2 = new CompanySession(course3,"7/4/2025",comp1,p3,comp2,5);
        PublicSession publicSession = new PublicSession(course2,"22/3/2025",comp1,p3);

       Consultancy consultancy = new Consultancy();
        Service[] services = {companySession1,consultancy,companySession2,publicSession};
        for (Service s : services){
            if (s instanceof Session){
                ((Session) s).printInfo();
            }
            System.out.println("The price for the " +s.getClass().getSimpleName() + " is " +s.calculatePrice() +".\n");
        }
      
    }
}
