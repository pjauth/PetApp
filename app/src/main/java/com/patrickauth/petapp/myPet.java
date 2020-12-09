package com.patrickauth.petapp;

public class Pet {
    protected int id;
    protected String name;
    protected int weight;
    protected String size;
    protected String breed;
    protected int ownerId;
    protected Owner owner;

    public Pet(int id) {
        this.id = id;
    }
}
