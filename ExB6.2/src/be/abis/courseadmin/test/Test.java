package be.abis.courseadmin.test;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        CompanyRepository cr = new MemoryListCompanyRepository();

        Course course1 = new Course("Java",5,500);
        Course course2 = new Course("SQL Fundamentals",2,450);
        Course course3 = new Course("TDD",2,450);

        System.out.println("\n------------------------ExB6.2 Companies via List----------------------------------");

        try {
        Company comp1 = cr.findCompany(1);
        Company comp2 = cr.findCompany("smals");
        Company comp3 = cr.findCompany(4);

        Company[] comps = {comp1,comp2,comp3};

        for (Company c: comps){
            System.out.println(c);
        }

        cr.addCompany(new Company(6,"ABBA5"));
        comp1.setName("SIBA");
        cr.updateCompany(comp1);
        cr.deleteCompany(3);

        List<Company> allCompanies = ((MemoryListCompanyRepository)cr).getCompanies();
        System.out.println(allCompanies);

        } catch (CompanyNotFoundException cnf){
            cnf.printStackTrace();
        }

        System.out.println("\n------------------------ExB6.2 With Exceptions----------------------------------");
        try {
            Company comp1 = cr.findCompany(8);
            System.out.println(comp1);

        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Company comp1 = cr.findCompany(3);
            System.out.println(comp1);

        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Company comp3 = cr.findCompany("x");
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }





    }
}
