package com.example.geektrust;

import java.text.SimpleDateFormat;
import java.util.*;

public class CourseManagementSystem {
    private ArrayList<CourseOffering> courseOfferings;
    private ArrayList<Employee> employees;
    private Map<String, String> courseRegistrationToCourseIdMap;

    public CourseManagementSystem() {
        courseOfferings = new ArrayList<>();
        employees = new ArrayList<>();
        courseRegistrationToCourseIdMap = new HashMap<>();
    }


    // Method to add course offerings
    public void addCourseOffering(CourseOffering course) {
        String courseId = "OFFERING-"+ course.getCourseTitle() + "-" + course.getInstructor();
        course.setCourseId(courseId);
        courseOfferings.add(course);
        System.out.println(courseId);
    }

    // Method to register employees in a course
    public void registerEmployee(String courseId, String emailId) {
        CourseOffering courseOffering = getCourseOfferingById(courseId);
        if (courseOffering.getRegisteredEmployees().size() >= courseOffering.getMaxEmployees()) {
            System.out.println(Statuses.COURSE_FULL_ERROR);
            return;
        }

        String name = emailId.substring(0, emailId.indexOf('@'));
        Employee employee = new Employee(name,emailId);
        courseOffering.getRegisteredEmployees().add(employee);
        String courseRegistrationId = "REG-COURSE-"+ name + "-" + courseOffering.getCourseTitle();
        courseRegistrationToCourseIdMap.put(courseRegistrationId, courseId);
        employee.setRegistrationNumber(courseRegistrationId);
        employees.add(employee);
        System.out.println(courseRegistrationId + " " + Statuses.ACCEPTED);
        employee.setCourseStatus(Statuses.ACCEPTED);

        if (courseOffering.getRegisteredEmployees().size() < courseOffering.getMinEmployees() && isCourseCanceled(courseOffering)) {
                employee.setCourseStatus(Statuses.COURSE_CANCELED);
        }
    }


    // Method to allot course to the employees
    public void allotCourse(String courseId){
        CourseOffering courseOffering = getCourseOfferingById(courseId);

        if(courseOffering!=null){
            courseOffering.getRegisteredEmployees().sort(Comparator.comparing(Employee::getRegistrationNumber));
            for(Employee employee: courseOffering.getRegisteredEmployees()){
                String registrationNumber = employee.getRegistrationNumber();
                String email = employee.getEmail();
                String courseStatus = employee.getCourseStatus().equals(Statuses.COURSE_CANCELED)? Statuses.COURSE_CANCELED : Statuses.CONFIRMED;
                System.out.println(registrationNumber + " " + email + " " + courseId + " " + courseOffering.getCourseTitle()
                + " " + courseOffering.getInstructor() + " " + courseOffering.getDate() + " " + courseStatus);
                employee.setCourseStatus(courseStatus);

            }
        }
    }


    // Method to cancel registration
    public void cancelRegistration(String courseRegistrationId) {
        Employee emp = null;
        for(Employee employee: employees){
            if (employee.getRegistrationNumber().equals(courseRegistrationId)) {
                emp = employee;
            }
        }
        if(emp.getCourseStatus().equals(Statuses.CONFIRMED)){
            System.out.println(courseRegistrationId + " " + Statuses.CANCEL_REJECTED);
            emp.setCourseStatus(Statuses.CANCEL_REJECTED);
        }
        else {
            System.out.println(courseRegistrationId + " " + Statuses.CANCEL_ACCEPTED);
            emp.setCourseStatus(Statuses.CANCEL_ACCEPTED);
        }
        String courseId = courseRegistrationToCourseIdMap.get(courseRegistrationId);
        if (courseId != null) {
            CourseOffering courseOffering = getCourseOfferingById(courseId);
            if (courseOffering != null) {
                courseOffering.getRegisteredEmployees().remove(emp);
            }
        }
    }

    private CourseOffering getCourseOfferingById(String courseId) {
        for (CourseOffering course : courseOfferings) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }


    private boolean isCourseCanceled(CourseOffering course) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            Date currentDate = new Date();
            Date courseDate = sdf.parse(course.getDate());

            if (currentDate.after(courseDate) && course.getRegisteredEmployees().size() < course.getMinEmployees()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<CourseOffering> getCourseOfferings(){
        return courseOfferings;
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }
}
