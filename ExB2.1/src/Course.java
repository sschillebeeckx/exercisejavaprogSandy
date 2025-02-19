public class Course {

    String title;
    int numberOfDays;
    double pricePerDay;

    public void printInfo(){
        System.out.println("The " + this.title + " course takes " + this.numberOfDays
                + " days, and costs " +this.pricePerDay + "€ per day.");
    }

    public double calculateTotalPrice(){
        return numberOfDays*pricePerDay;
    }
}
