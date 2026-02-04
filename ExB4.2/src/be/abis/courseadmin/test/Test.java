package be.abis.courseadmin.test;

import be.abis.courseadmin.model.*;

public class Test {

    public static void main(String[] args) {

        Course course1 = new Course("Java",5,500);
        Course course2 = new Course("TDD",2,450);

        Company comp1 = new Company("Abis");
        Company comp2 = new Company("IBM");

        Person p1 = new Person("Mary","Jones",comp1);
        Person p2=new Person("John","Doe");
        Person p3 = new Person("Bob","Janssens",new Company("TTL"));


        System.out.println("\n------------------------ExB4.2 Sessions----------------------------------");
        Session session = new Session(course1,"24/02/2025",comp1,p2);
        CompanySession companySession1 = new CompanySession(course2,"5/3/2025",comp1,p3,comp2);
        CompanySession companySession2 = new CompanySession(course1,"7/4/2025",comp2,p1,comp2,5);
        PublicSession publicSession = new PublicSession(course2,"22/3/2025",PublicSession.getABIS(),p3);
        Session[] sessions={session,companySession1,companySession2,publicSession};
        for (Session s: sessions){
            s.printInfo();
            System.out.println();
        }

    }
}
