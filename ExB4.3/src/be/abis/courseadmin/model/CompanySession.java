package be.abis.courseadmin.model;

public class CompanySession extends Session {

    private Company organizer;
    private int numberOfParticipants;

    public CompanySession(Course course, String startDate, Company location, Person instructor, Company organizer) {
        super(course, startDate, location, instructor);
        this.organizer = organizer;
    }

    public CompanySession(Course course, String startDate, Company location, Person instructor, Company organizer, int numberOfParticipants) {
        this(course, startDate, location, instructor, organizer);
        this.numberOfParticipants = numberOfParticipants;
    }

    public Company getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Company organizer) {
        this.organizer = organizer;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void printInfo(){
        super.printInfo();
        System.out.println("This session is offered to you by " + this.organizer.getName() + "." + ((numberOfParticipants!=0)?" There will be " + numberOfParticipants + " participants.":""));
    }

    public double calculatePrice(){
        return 400.0;
    }

}
