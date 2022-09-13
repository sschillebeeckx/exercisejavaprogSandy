public class Course {

    String title;
    int numberOfDays;
    double pricePerDay;

    public void printInfo(){
        System.out.println("The " + title + " course takes " + numberOfDays + " days, and costs " +pricePerDay + "€ per day.");
    }

    public double calculateTotalPrice(){
        return numberOfDays*pricePerDay;
    }
}
