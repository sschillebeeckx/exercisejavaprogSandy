package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.PriceTooHighException;

public class Company {

    private int companyNumber;
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public Company(int companyNumber, String name) {
        this(name);
        this.companyNumber = companyNumber;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Company " + companyNumber + " is "+ name+".";
    }

    public double requestPriceOfferForCompanySession(Course c, int numberOfParticipants) throws PriceTooHighException {
        CompanySession cs = new CompanySession(c,numberOfParticipants);
        double price = cs.calculatePrice();
        return price;
    }
}
