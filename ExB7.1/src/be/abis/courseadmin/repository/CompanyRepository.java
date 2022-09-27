package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

public interface CompanyRepository {

    Company findCompany(int id) throws CompanyNotFoundException;
    Company findCompany(String name) throws CompanyNotFoundException;
    void addCompany(Company c);
    void updateCompany(Company c) throws CompanyNotFoundException;
    void deleteCompany(int id) throws CompanyNotFoundException;

}
