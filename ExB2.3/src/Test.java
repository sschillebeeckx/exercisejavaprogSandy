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


    }
}
