package com.lufthansa.DTO;


public class Passenger {
    private String name;
    private String middleName;
    private String lastName;
    private String gender;
    private String date;

    public Passenger(String name, String middleName, String lastName, String gender, String date) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
