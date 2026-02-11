package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.FileCompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AbisCompanyService implements CompanyService {

    CompanyRepository cr = new FileCompanyRepository();

    @Override
    public List<Company> sortAllCompaniesByName() {
        List<Company> companies = ((MemoryListCompanyRepository)cr).getCompanies();
        Collections.sort(companies);
        return companies;
    }

    @Override
    public List<Company> sortAllCompaniesByCompanyNumber() {
        List<Company> companies = ((MemoryListCompanyRepository)cr).getCompanies();
        companies.sort(new Company.CompanyByNumberComparator());

        //Collections.sort(companies,(Company c1, Company c2) -> c1.getCompanyNumber()-c2.getCompanyNumber());
        Comparator<Company> myComparator = ( c1,  c2) -> c1.getCompanyNumber()-c2.getCompanyNumber();
        companies.sort(( c1,  c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return companies;
    }


}
