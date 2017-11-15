package com.JAKEGODFREY.crud_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrudDirective {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrudDirective.class);
    private long userID = 0L;
    private String firstName;
    private String lastName;
    private String age;

    public Long addUserID(Long userID){
        return this.userID = userID + 1;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
