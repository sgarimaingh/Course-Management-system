package com.example.geektrust;

public class ProcessCommands {

    CourseManagementSystem cms = new CourseManagementSystem();

    public void processAddOfferingCommand(String[] words){
        if (words.length >= 6) {
            String courseTitle = words[1];
            String instructor = words[2];
            String date = words[3];
            int minEmployees = Integer.parseInt(words[4]);
            int maxEmployees = Integer.parseInt(words[5]);
            cms.addCourseOffering(courseTitle, instructor, date, minEmployees, maxEmployees);
        }
        else {
            System.out.println(Statuses.INPUT_DATA_ERROR);
        }
    }

    public void processRegisterCommand(String[] words){
        if (words.length >= 3) {
            String emailId = words[1];
            String courseId = words[2];
            cms.registerEmployee(courseId,emailId);
        }
        else{
            System.out.println(Statuses.INPUT_DATA_ERROR);
        }
    }

    public void processCancelRegistrationCommand(String[] words){
        String courseRegistrationId = words[1];
        cms.cancelRegistration(courseRegistrationId);
    }

    public void processAllotCommand(String[] words){
        String courseId = words[1];
        cms.allotCourse(courseId);
    }
}
