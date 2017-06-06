package com.example.homepagemod;

/**
 * Created by alice on 5/31/2017.
 */

public class Contact {

    String FullName, Username, Password, CarType, LicensePlate, Email;


    public void setFullName(String Fullname){
        this.FullName = Fullname;
    }
    public String getFullName(){
        return this.FullName;
    }

    public void setUsername(String Username){
        this.Username = Username;
    }
    public String getUsername(){
        return this.Username;
    }

    public void setPassword(String Password){
        this.Password = Password;
    }
    public String getPassword(){
        return this.Password;
    }

    public void setCarType(String CarType){
        this.CarType = CarType;
    }
    public String getCarType(){return this.CarType;}

    public void setLicensePlate(String LicensePlate){
        this.LicensePlate = LicensePlate;
    }
    public String getLicensePlate(){
        return this.LicensePlate;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }
    public String getEmail(){
        return this.Email;
    }
}

