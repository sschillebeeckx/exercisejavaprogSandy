package be.abis.courseadmin.test;

import be.abis.courseadmin.exception.CompanyAlreadyExistsException;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.FileCompanyRepository;

public class TestMain {

    public static void main(String[] args) {

        CompanyRepository cr = new FileCompanyRepository();

        try {
            Company comp1 = cr.findCompany(1);
            System.out.println(comp1);
            Company comp2 = cr.findCompany("smals");
            System.out.println(comp2);

            Company newComp = new Company("new comp");
            cr.addCompany(newComp);
            newComp.setName("Better name");
            cr.updateCompany(newComp);

            cr.deleteCompany(1);

            System.out.println("\n------------------------Exceptions----------------------------------");

            try {
                Company comp3 = cr.findCompany(10);
            } catch (CompanyNotFoundException cnf) {
                System.out.println(cnf.getMessage());
            }

            try {
                 Company comp4 = cr.findCompany("smils");
            } catch (CompanyNotFoundException cnf) {
                System.out.println(cnf.getMessage());
            }

            Company newComp2 = new Company("ibm");

            try {
                cr.addCompany(newComp2);
            } catch (CompanyAlreadyExistsException caee) {
                System.out.println(caee.getMessage());
            }


        } catch (CompanyNotFoundException | CompanyAlreadyExistsException cnf) {
            cnf.printStackTrace();
        }

    }
}
