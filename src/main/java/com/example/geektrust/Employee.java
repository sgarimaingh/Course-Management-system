package com.example.geektrust;

public class Employee {

    private String registrationNumber;
    private String name;
    private String email;
    private String courseStatus;


    public Employee(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void setCourseStatus(String courseStatus){
        this.courseStatus = courseStatus;
    }

    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber(){
        return this.registrationNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCourseStatus(){
        return this.courseStatus;
    }


}
