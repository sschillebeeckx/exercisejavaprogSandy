package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.util.ArrayList;
import java.util.List;

public class MemoryListCompanyRepository implements CompanyRepository {

    private List<Company> companies = new ArrayList<>();

    public MemoryListCompanyRepository() {
        companies.add(new Company(1,"ABIS"));
        companies.add(new Company(2,"Smals"));
        companies.add(new Company(3,"IBM"));
        companies.add(new Company(4,"TTL"));
        companies.add(new Company(5,"CogniTIC"));
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        Company foundCompany=null;
        for (Company c:companies){
            if (c.getCompanyNumber()==id){
                foundCompany=c;
            }
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
        companies.add(c);
    }

    @Override
    public void updateCompany(Company c) throws CompanyNotFoundException {
        Company compToUpdate = this.findCompany(c.getCompanyNumber());
        compToUpdate.setName(c.getName());
    }

    @Override
    public void deleteCompany(int id) throws CompanyNotFoundException {
        companies.remove(this.findCompany(id));
    }
}
