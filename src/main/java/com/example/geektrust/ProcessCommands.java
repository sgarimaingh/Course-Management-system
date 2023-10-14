package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ProcessCommands {

    CourseManagementSystem cms = new CourseManagementSystem();

    public void processCommands(String[] args){
        try {
            FileInputStream f = new FileInputStream(args[0]);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split(" ");
                if (words.length > 0) {
                    String command = words[0];
                    switch (command) {
                        case "ADD-COURSE-OFFERING":
                            processAddOfferingCommand(words);
                            break;
                        case "REGISTER":
                            processRegisterCommand(words);
                            break;
                        case "CANCEL":
                            processCancelRegistrationCommand(words);
                            break;
                        case "ALLOT":
                            processAllotCommand(words);
                            break;
                        default:
                            System.out.println("Unknown command: " + command);
                    }
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void processAddOfferingCommand(String[] words){
        if (words.length >= 6) {
            String courseTitle = words[1];
            String instructor = words[2];
            String date = words[3];
            int minEmployees = Integer.parseInt(words[4]);
            int maxEmployees = Integer.parseInt(words[5]);
            CourseOffering newCourse = new CourseOffering(courseTitle, instructor, date, minEmployees, maxEmployees);
            cms.addCourseOffering(newCourse);
        }
        else {
            System.out.println(Statuses.INPUT_DATA_ERROR);
        }
    }

    private void processRegisterCommand(String[] words){
        if (words.length >= 3) {
            String emailId = words[1];
            String courseId = words[2];
            cms.registerEmployee(courseId,emailId);
        }
        else{
            System.out.println(Statuses.INPUT_DATA_ERROR);
        }
    }

    private void processCancelRegistrationCommand(String[] words){
        String courseRegistrationId = words[1];
        cms.cancelRegistration(courseRegistrationId);
    }

    private void processAllotCommand(String[] words){
        String courseId = words[1];
        cms.allotCourse(courseId);
    }
}
