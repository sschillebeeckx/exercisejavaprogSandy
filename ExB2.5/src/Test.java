public class Test {

    public static void main(String[] args) {

        System.out.println("------------------------Course----------------------------------");
        Course c = new Course("Java",5,500);
        c.printInfo();
        double totalPrice=c.calculateTotalPrice();
        System.out.println("The total price is " + totalPrice +".");

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
        
    }
}
