package com.patrickauth.petapp;

public class Owner {
    int ID;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zipCode;
    String email;
    String password;
    String phone;

    public Owner(int ID, String firstName, String lastName, String address, String city,
            String state, int zipCode, String email, String password, String phone){

        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.password = password;
        this.phone = phone;

    }

    public int getID(){
        return ID;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getPhone(){
        return phone;
    }



}
