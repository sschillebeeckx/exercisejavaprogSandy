package be.abis.courseadmin.model;

public class Service {

    public double calculatePrice(){
        return 100.0;
    }

    public void printCalculatedPriceInfo(){
        System.out.println("The price for the " +this.getClass().getSimpleName() + " is " +this.calculatePrice() +".\n");
    }

}
