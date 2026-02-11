package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.service.AbisCompanyService;
import be.abis.courseadmin.service.CompanyService;

import java.time.LocalDate;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        CompanyService cs = new AbisCompanyService();

        System.out.println("\n------------------------ExB6.8 Sort all companies by name----------------------------------");

        List<Company> companiesSortedByName = cs.sortAllCompaniesByName();
        System.out.println(companiesSortedByName);

        System.out.println("\n------------------------ExB6.8 Sort all companies by number----------------------------------");

        List<Company> companiesSortedByNumber = cs.sortAllCompaniesByCompanyNumber();
        System.out.println(companiesSortedByNumber);



    }
}
