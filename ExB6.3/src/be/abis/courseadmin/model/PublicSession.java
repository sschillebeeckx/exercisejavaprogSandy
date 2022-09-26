package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.ArrayList;
import java.util.List;

public class PublicSession extends Session {

    CompanyRepository cr = new MemoryListCompanyRepository();

    private List<CourseParticipant> enrolments = new ArrayList<>();

    public PublicSession(Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
    }

    public List<CourseParticipant> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<CourseParticipant> enrolments) {
        this.enrolments = enrolments;
    }

    public void addEnrolment(CourseParticipant cp){
        enrolments.add(cp);
        System.out.println(cp + " was added as participant.");
    }

    public void addEnrolments(CourseParticipant... cps){
        for (CourseParticipant cp:cps)  addEnrolment(cp);
    }

    public void cancelEnrolment(CourseParticipant cp){
        enrolments.remove(cp);
        System.out.println(cp + " cancelled " +( (Person)cp).getGender().getPossessivePronoun() + " enrolment.");
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
