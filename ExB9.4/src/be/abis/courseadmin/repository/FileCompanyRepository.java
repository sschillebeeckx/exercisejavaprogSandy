package be.abis.courseadmin.repository;

import be.abis.courseadmin.exception.CompanyAlreadyExistsException;
import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileCompanyRepository implements CompanyRepository {

    private List<Company> companies;
    String pathToFile = "/temp/javacourses/companies.txt";

    public FileCompanyRepository() {
        companies = new ArrayList<>();
        this.readFile();
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> readFile(){
        if (companies.size()!=0)companies.clear();
        Company.setCompanyCounter(0);
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile));){
            String compName=null;
            while ((compName=br.readLine())!=null){
                companies.add(new Company(compName.trim()));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return companies;
    }

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
    public void addCompany(Company c) throws CompanyAlreadyExistsException {
        boolean b=false;
        this.readFile();
        String compToAdd = c.getName();
        Iterator<Company> iter = companies.iterator();
        try (PrintWriter pw = new PrintWriter(new FileWriter(pathToFile, true));){
            while (iter.hasNext()){
                Company comp= iter.next();
                String compName = comp.getName();
                if (compToAdd.equalsIgnoreCase(compName)) { throw new CompanyAlreadyExistsException("Company " + compName + " already exists." );}
                else {b=true;}

            }

            if (b){
                pw.append("\n"+compToAdd);
                companies.add(c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCompany(Company c) throws CompanyNotFoundException {
        this.readFile();
       Company foundCompany= this.findCompany(c.getCompanyNumber());
       foundCompany.setName(c.getName());
        try {
            this.writeAllCompanies();
        } catch (IOException e) {
            System.out.println("Problem writing to the file.");
        }
    }

    @Override
    public void deleteCompany(int id) throws CompanyNotFoundException {
        this.readFile();
        Iterator<Company> iter = companies.iterator();
        boolean removed= false;
        while(iter.hasNext()){
            Company comp= iter.next();
            int companyNumber= comp.getCompanyNumber();
            if (companyNumber==id){
                iter.remove();
                removed=true;
            }

        }

        if(removed){
            try {
                this.writeAllCompanies();
            } catch (IOException e) {
                System.out.println("Problem writing to the file.");
            }
        } else {
            throw new CompanyNotFoundException("Company to remove did not exist.");
        }
    }

    private void writeAllCompanies() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(pathToFile));

        for (Company c : companies) {
            pw.println(c.getName());
        }

        pw.close();
    }

}
