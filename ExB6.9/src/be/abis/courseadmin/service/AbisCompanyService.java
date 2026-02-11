package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.Collections;
import java.util.List;

public class AbisCompanyService implements CompanyService{

    CompanyRepository cr = new MemoryListCompanyRepository();

  /*  public AbisCompanyService(CompanyRepository cr){
        this.cr=cr;
    } */

    @Override
    public List<Company> sortAllCompaniesByName() {
       // List<Company> companies = ((MemoryListCompanyRepository)cr).getCompanies();
        List<Company> companies = cr.findAllCompanies();
        Collections.sort(companies);
        return companies;
    }

    @Override
    public List<Company> sortAllCompaniesByCompanyNumber() {
        //List<Company> companies = ((MemoryListCompanyRepository)cr).getCompanies();
        List<Company> companies = cr.findAllCompanies();
        Collections.sort(companies,new Company.CompanyByNumberComparator());
        //companies.sort(new Company.CompanyByNumberComparator());
        return companies;
    }


}
