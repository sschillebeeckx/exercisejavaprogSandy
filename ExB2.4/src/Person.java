public class Person {

    private String firstName;
    private String lastName;
    private Company company;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, Company company) {
        this(firstName, lastName);
        this.company = company;
    }

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
        System.out.println(firstName + " " + lastName + ((c!=null)?" works for " + c.getName() +"." : " is not linked to a company for the moment."));
    }
}
