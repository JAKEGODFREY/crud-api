package com.JAKEGODFREY.crud_api.domain;

public class Employee {

    private int userID;
    private String firstName;
    private String lastName;
    private int age;

    /**
     * empty contructor
     */
    public Employee(){}

    /**
     * An employee object constructor
     * @param userID the users ID
     * @param firstName the users first name
     * @param lastName the users last name
     * @param age the users age
     */
    public Employee(int userID, String firstName, String lastName, int age) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
