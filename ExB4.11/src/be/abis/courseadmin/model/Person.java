package be.abis.courseadmin.model;

/**
 * This is the person class. Each person has a firstName, lastName and a list of hobbies. A person is optionnally linked to a company.
 * @author Sandy
 **/
public class Person implements Instructor,CourseParticipant{

    private static int counter;
    private int personNumber;
    private String firstName;
    private String lastName;
    private Company company;
    private String[] hobbies=new String[10];
    private int hobbiesIndex;

    public Person(String firstName, String lastName) {
        personNumber=++counter;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, Company company) {
        this(firstName, lastName);
        this.company = company;
    }

    public static int getCounter() {
        return counter;
    }

  /*  public static void setCounter(int counter) {
        Person.counter = counter;
    }*/

    public int getPersonNumber() {
        return personNumber;
    }

   /* public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void addHobby(String hobby){
        hobbies[hobbiesIndex]=hobby;
        hobbiesIndex++;
    }

    /** adding hobbies based on a vararg**/
    public void addHobbies(String... hobbies){
        for (String hobby:hobbies){
            this.addHobby(hobby);
        }
    }

    public String toString(){
        return firstName + " " + lastName;
    }

    /** Prints all the person's information**/
    public void printInfo(){
        Company c = company;
        System.out.println("Person " + personNumber + ": " + this + ((c!=null)?" works for " + c.getName() +"." : " is not linked to a company for the moment."));
    }

    /** A person can attend a course. The method uses the calculatePrice() method.
     *
     * @param c
     * @see Course
     */
    public void attendCourse(Course c){
        System.out.println(this + " is following a " + c + " course. This costs " + c.calculateTotalPrice() + "€.");
    }


    @Override
    public void teachCourse(Course c) {
        System.out.println(this + " is teaching a " + c + " course.");
    }
}
