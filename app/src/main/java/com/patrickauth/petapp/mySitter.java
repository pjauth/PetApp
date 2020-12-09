package com.patrickauth.petapp;

public class Sitter {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String preference;
    protected int jobCount;
    protected float rating;
    protected int points;
    protected String email;
    protected String phone;
    protected Address address;

    public Sitter(int id) {
        this.id = id;
    }
}
