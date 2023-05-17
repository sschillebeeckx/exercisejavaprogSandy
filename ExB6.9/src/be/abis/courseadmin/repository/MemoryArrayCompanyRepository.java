package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.Arrays;
import java.util.List;

public class MemoryArrayCompanyRepository implements CompanyRepository {

    private Company[] companies = new Company[5];

    public MemoryArrayCompanyRepository(){
        companies[0]=new Company(1,"ABIS");
        companies[1]=new Company(2,"Smals");
        companies[2]=new Company(3,"IBM");
        companies[3]=new Company(4,"TTL");
        companies[4]=new Company(5,"CogniTIC");
    }

    @Override
    public List<Company> findAllCompanies() {
        return Arrays.asList(companies);
    }


    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        Company foundCompany = null;

        try {
            foundCompany = companies[id - 1];
        } catch (ArrayIndexOutOfBoundsException ae){
            throw new CompanyNotFoundException("Company " + id + " can not be found.");
        }
        if (foundCompany==null) throw new CompanyNotFoundException("Company " + id + " can not be found.");
        return foundCompany;
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        Company foundCompany=null;
        for (Company c:companies){
            if (c.getName().equalsIgnoreCase(name)){
                foundCompany=c;
            }
        }
        if (foundCompany==null) throw new CompanyNotFoundException("Company " + name + " can not be found.");
        return foundCompany;
    }

    @Override
    public void addCompany(Company c) {

    }

    @Override
    public void updateCompany(Company c) {

    }

    @Override
    public void deleteCompany(int id) {

    }


}
