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
        p1.printInfo();
        Person p2=new Person("John","Doe");
        p2.printInfo();

        
    }
}
