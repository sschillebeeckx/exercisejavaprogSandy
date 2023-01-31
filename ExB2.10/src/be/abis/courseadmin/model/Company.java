package be.abis.courseadmin.model;

/** This is the company class. skmdjfkshdf
 * @author Sandy
 */
public class Company {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** printing stuff */
    public void printInfo(){
        System.out.println("The company's name is " + name+".");
    }
}
