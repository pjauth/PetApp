package com.patrickauth.petapp;

public class Address {
    protected String street;
    protected String city;
    protected String state;
    protected int zipcode;
    protected int distance;

    public Address() {}

    public Address(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return this.street + ", " + this.city + " " + this.state + " " + this.zipcode;
    }
}
