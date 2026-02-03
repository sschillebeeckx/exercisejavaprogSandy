public class Test {

    public static void main(String[] args) {
        Course c = new Course();
        c.title="Java";
        c.numberOfDays=4;
        c.pricePerDay=550;


        c.printInfo();


        //System.out.println("The total price is " + totalPrice +".");
        //System.out.println("The total price is " + c.calculateTotalPrice() +".");
    }
}
