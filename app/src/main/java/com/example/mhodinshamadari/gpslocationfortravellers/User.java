package com.example.mhodinshamadari.gpslocationfortravellers;

/**
 * Created by mhodinshamadari on 30-03-2018.
 */

public class User {


    public String username;
    public String phonenumber;
    double lat;
    double lng;
    android.location.Location loc;


    public User() {
    }

    public User(String username, String phonenumber) {
        this.username = username;
        this.phonenumber = phonenumber;

    }



    public String getUsername() {
        return username;
    }

    public String getPhonenumber() {
        return phonenumber;


    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    // public String

}