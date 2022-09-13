public class Course {

    private String title;
    private int numberOfDays;
    private double pricePerDay;

    public Course(String title, int numberOfDays, double pricePerDay){
        this.title=title;
        this.numberOfDays=numberOfDays;
        this.pricePerDay=pricePerDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void printInfo(){
        System.out.println("The " + title + " course takes " + numberOfDays + " days, and costs " +pricePerDay + "€ per day.");
        System.out.println("Total price is: " +this.calculateTotalPrice() + "€.");
    }

    double calculateTotalPrice(){
        return numberOfDays*pricePerDay;
    }

    public double calculateTotalPrice(int reduction){
        return this.calculateTotalPrice()*(1-reduction/100.);
    }

}
