package be.abis.courseadmin.model;

public class PublicSession extends Session {

    private final static Company ABIS = new Company("Abis");

    public PublicSession(Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
    }

    public static Company getABIS() {
        return ABIS;
    }

    public double calculatePrice(){
        return 300.0;
    }

}
