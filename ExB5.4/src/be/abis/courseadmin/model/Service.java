package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.PriceTooHighException;

public abstract class Service {

    public abstract double calculatePrice() throws PriceTooHighException;

}
