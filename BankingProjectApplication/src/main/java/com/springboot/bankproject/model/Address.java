package com.springboot.bankproject.model;

public class Address {
    String street;
    String city;
    String state;
    String country;
    Integer pinCode;

    public Address(String street, String city, String state, String country, Integer pinCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + ", pinCode=" + pinCode + ", state=" + state
                + ", street=" + street + "]";
    }

}
