public class Person {

    private static int counter;
    private int personNumber;
    private String firstName;
    private String lastName;
    private Company company;

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

    public void printInfo(){
        Company c = company;
        System.out.println("Person " + personNumber + ": " +firstName + " " + lastName + ((c!=null)?" works for " + c.getName() +"." : " is not linked to a company for the moment."));
    }

    public void attendCourse(Course c){
        System.out.println(firstName + " is attending a " + c.getTitle() + " course.");
    }
}
