package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.repository.CompanyRepository;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.ArrayList;
import java.util.Iterator;
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
       // System.out.println(cp + " was added as participant.");
    }

    public void addEnrolments(CourseParticipant... cps){
        for (CourseParticipant cp:cps)  addEnrolment(cp);
    }

    public void cancelEnrolment(CourseParticipant cp){
        enrolments.remove(cp);
       // System.out.println(cp + " cancelled " +( (Person)cp).getGender().getPossessivePronoun() + " enrolment.");
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

    public void printParticipantList(){
        System.out.println("Participant list for the " + this.getCourse() + " course on " + this.getStartDate() + ":\n");
        for(CourseParticipant cp: enrolments){
            ((Person)cp).printInfo();
            System.out.println();
        }
    }

    public List<CourseParticipant> findAbisParticipants(){



        List<CourseParticipant> abisParticipants= new ArrayList<>();
        for(CourseParticipant cp: enrolments){
           Person p= (Person)cp;
           Company c= p.getCompany();
           if (c!=null){
               if (c.getName().equalsIgnoreCase("Abis")){
                   abisParticipants.add(p);
               }
           }
        }
        return abisParticipants;
    }

    public void removeAbisParticipants(){
        Iterator<CourseParticipant> iter = enrolments.iterator();
        while (iter.hasNext()){
            Person p= (Person)iter.next();
            Company c= p.getCompany();
            if (c!=null){
                if (c.getName().equalsIgnoreCase("Abis")){
                    iter.remove();
                }
            }
        }
    }
}
