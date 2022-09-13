package be.abis.courseadmin.model;

public class PublicSession extends Session {

    private static Company ABIS = new Company("Abis");

    public PublicSession(Course course, String startDate, Company location, Person instructor) {
        super(course, startDate, location, instructor);
    }

    public static Company getABIS() {
        return ABIS;
    }
}
