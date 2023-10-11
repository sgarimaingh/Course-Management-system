package com.example.geektrust;

import java.util.ArrayList;

public class CourseRegistration {
    private ArrayList<CourseOffering> courseOfferings;

    public CourseRegistration() {
        courseOfferings = new ArrayList<>();
    }

    public void addCourseOffering(String courseTitle, String instructor, String date, int minEmployees, int maxEmployees) {
        CourseOffering newCourse = new CourseOffering(courseTitle, instructor, date, minEmployees, maxEmployees);
        String courseId = "OFFERING-"+ courseTitle + "-" + instructor;
        newCourse.setCourseId(courseId);
        courseOfferings.add(newCourse);

    }

    public void print(){
        for(int i=0;i<courseOfferings.size();i++){
            System.out.println(courseOfferings.get(i).getCourseId());
            System.out.println(courseOfferings.get(i).getCourseTitle());
            System.out.println(courseOfferings.get(i).getInstructor());
        }

    }

    public String registerEmployee(CourseOffering course, Employee employee) {
        if (course.getRegisteredEmployees().size() >= course.getMaxEmployees()) {
            return Constants.COURSE_FULL_ERROR;
        }

        course.getRegisteredEmployees().add(employee);
        return Constants.ACCEPTED;
    }

//
//    public void cancelRegistration(CourseOffering course, Employee employee) {
//        course.getRegisteredEmployees().remove(employee);
//    }
}
