package be.abis.courseadmin.test;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;

public class TestMain {

    public static void main(String[] args) {

        CompanyRepository cr = new MemoryArrayCompanyRepository();

        try {
            Company comp1 = cr.findCompany(1);
            System.out.println(comp1);

        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Company comp2 = cr.findCompany(20);
        } catch (CompanyNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Company comp3 = cr.findCompany("ABIS");
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
