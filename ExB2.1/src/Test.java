public class Test {

    public static void main(String[] args) {
        Course c = new Course();
        c.title="Java";
        c.numberOfDays=5;
        c.pricePerDay=500;

        c.printInfo();
        double totalPrice=c.calculateTotalPrice();
        System.out.println("The total price is " + totalPrice +".");


    }
}
