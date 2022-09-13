package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Person;
import be.abis.courseadmin.model.Course;

public class Test {

    public static void main(String[] args) {

        System.out.println("------------------------Course----------------------------------");
        Course c = new Course("Java",5,500);
        c.printInfo();
       // c.calculateTotalPrice();

        System.out.println("\n------------------------Company----------------------------------");
        Company comp1 = new Company("Abis");
        comp1.printInfo();

        System.out.println("\n------------------------Persons----------------------------------");
        Person p1 = new Person("Mary","Jones",comp1);
        Person p2=new Person("John","Doe");
        Person p3 = new Person("Bob","Janssens",new Company("Smals"));
        Person[] persons = {p1,p2,p3};
        System.out.println("There were " + Person.getCounter() + " persons created:");
        for (Person p: persons){
            p.printInfo();
        }

        System.out.println("\n------------------------Course with reduction----------------------------------");
        double reductionPrice = c.calculateTotalPrice(10);
        System.out.println("The reduced price is " + reductionPrice +".");

        System.out.println("\n------------------------Follow course----------------------------------");
        p3.attendCourse(c);

        System.out.println("\n------------------------Hobbies----------------------------------");
        p1.addHobby("soccer");
        p2.addHobbies("gaming","walking","cooking");
        p3.addHobbies("soccer","dancing");
        for(Person p:persons){
            System.out.println(p.getFirstName() + "'s hobbies are:");
            for (String hobby: p.getHobbies()){
                if(hobby!=null) System.out.println(hobby);
            }
        }
    }
}
