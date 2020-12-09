package com.patrickauth.petapp;

public class Pet {

    int petID;
    String name;
    int weight;
    String size;
    String breed;
    int ownerID;

    public Pet(int petID, String name, int weight, String size, String breed, int ownerID){
        this.petID = petID;
        this.name = name;
        this.weight = weight;
        this.size = size;
        this.breed = breed;
        this.ownerID = ownerID;
    }

    public int getPetID(){
        return petID;
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }

    public String getSize(){
        return size;
    }

    public String getBreed(){
        return breed;
    }

    public int getOwnerID(){
        return ownerID;
    }
}
