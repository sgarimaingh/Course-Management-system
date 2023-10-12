package com.example.geektrust;

import java.util.ArrayList;

public class CourseOffering {

    private String courseId;
    private String courseTitle;
    private String instructor;
    private String date;
    private int minEmployees;
    private int maxEmployees;
    private ArrayList<Employee> registeredEmployees = new ArrayList<>();

    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    public String getCourseId(){
        return this.courseId;
    }
    public String getCourseTitle(){
        return this.courseTitle;
    }
    public String getInstructor(){
        return this.instructor;
    }
    public String getDate(){
        return this.date;
    }
    public int getMinEmployees(){
        return this.minEmployees;
    }
    public int getMaxEmployees(){
        return this.maxEmployees;
    }

    public ArrayList<Employee> getRegisteredEmployees(){
        return this.registeredEmployees;
    }

    public CourseOffering(String courseTitle, String instructor, String date, int minEmployees, int maxEmployees){
        this.courseTitle = courseTitle;
        this.instructor = instructor;
        this.date = date;
        this.minEmployees = minEmployees;
        this.maxEmployees = maxEmployees;
    }
}
