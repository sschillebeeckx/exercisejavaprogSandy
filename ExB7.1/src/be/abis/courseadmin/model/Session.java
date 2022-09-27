package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.PriceTooHighException;
import be.abis.courseadmin.util.DateUtils;

import java.time.LocalDate;

public abstract class Session extends Service {

    private Course course;
    private LocalDate startDate;
    private Company location;
    private Person instructor;

    public Session(Course course){
        this.course=course;
    }

    public Session(Course course, LocalDate startDate, Company location, Person instructor) {
        this(course);
        this.startDate = startDate;
        this.location = location;
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Company getLocation() {
        return location;
    }

    public void setLocation(Company location) {
        this.location = location;
    }

    public Person getInstructor() {
        return instructor;
    }

    public void setInstructor(Person instructor) {
        this.instructor = instructor;
    }

    public void printInfo(){
        Company instructorComp=instructor.getCompany();
        System.out.println("The " + course.getTitle()+ " course will start on "+ DateUtils.format(startDate) + ". It will take place at " + location.getName() +
                ". Your instructor is "+ instructor.getFirstName()+ " " + instructor.getLastName()+ ((instructorComp!=null)? " of " + instructor.getCompany().getName()+".":"."));
    }

    public double calculatePrice() throws PriceTooHighException {
        return 200.0;
    }

    public abstract Company getOrganizer();



}
