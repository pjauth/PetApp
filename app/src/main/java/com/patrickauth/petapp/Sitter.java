package com.patrickauth.petapp;

public class Sitter {

    int sitterID;
    String firstName;
    String lastName;
    String preference;
    int jobCount;
    float rating;
    int points;
    String email;
    String phone;
    String address;
    String city;
    String state;
    int zipCode;

    public Sitter(int sitterID, String firstName, String lastName, String preference, int jobCount,
            float rating, int points, String email, String phone, String address, String city,
            String state, int zipCode){
        this.sitterID = sitterID;
        this.firstName =firstName;
        this.lastName = lastName;
        this.preference = preference;
        this.jobCount = jobCount;
        this.preference = preference;
        this.rating = rating;
        this.points = points;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;

    }

    public int getSitterID(){
        return sitterID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPreference(){
        return preference;
    }

    public int getJobCount(){
        return jobCount;
    }

    public float getRating(){
        return rating;
    }

    public int getPoints(){
        return points;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState(){
        return state;
    }

    public int getZipCode(){
        return zipCode;
    }

}
