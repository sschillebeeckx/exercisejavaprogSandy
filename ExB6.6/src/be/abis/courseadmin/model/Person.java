package be.abis.courseadmin.model;

import be.abis.courseadmin.enumeration.Gender;
import be.abis.courseadmin.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the person class. Each person has a firstName, lastName and a list of hobbies. A person is optionnally linked to a company.
 * @author Sandy
 **/
public class Person implements Instructor, CourseParticipant {

    private static int counter;
    private int personNumber;
    private String firstName;
    private String lastName;
    private Company company;
    private Set<String> hobbies=new HashSet<>();
    private Gender gender;

    public Person(String firstName, String lastName,Gender gender) {
        personNumber=++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender=gender;
    }

    public Person(String firstName, String lastName,Gender gender, Company company) {
        this(firstName, lastName,gender);
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void addHobby(String hobby){
        hobbies.add(hobby);
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
        System.out.println("Person " + personNumber + "'s first name is " +firstName + ". ");
        System.out.println(StringUtils.capitalize(gender.getPossessivePronoun()) + " last name is " + lastName+".");
        System.out.println(StringUtils.capitalize(gender.getPersonalPronoun()) + ((c!=null)?" works for " + c.getName() +"." : " is not linked to a company for the moment."));
        System.out.println("In " + gender.getPossessivePronoun() + " free time, you can find " + gender.getReflexivePronoun() + " practising one of following hobbies: " );
        for (String hobby:hobbies){
            if (hobby!=null)  System.out.println(hobby);
        }
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
