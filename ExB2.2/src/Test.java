public class Test {

    public static void main(String[] args) {
        Course c = new Course("Java",5,500);

        c.printInfo();
        double totalPrice=c.calculateTotalPrice();
        System.out.println("The total price is " + totalPrice +".");

    }
}
