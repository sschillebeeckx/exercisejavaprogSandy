package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

public class PublicSession extends Session {

    CompanyRepository cr = new MemoryListCompanyRepository();



    public PublicSession(Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
    }

    public double calculatePrice(){
        return 300.0;
    }

    @Override
    public Company getOrganizer() {
        Company c=null;
        try {
           c= cr.findCompany("Abis");
        } catch (CompanyNotFoundException e) {

        }
        return c;
    }
}
