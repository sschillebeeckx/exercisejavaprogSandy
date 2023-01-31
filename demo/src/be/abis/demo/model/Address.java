package be.abis.demo.model;

 public class Address {
    private String street;
    private String number;
    private String town;

    public Address(String street, String number, String town) {
        this.street = street;
        this.number = number;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
