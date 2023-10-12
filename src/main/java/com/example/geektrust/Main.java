package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();

        try {
            FileInputStream f = new FileInputStream(args[0]);
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split(" ");

                if (words.length > 0) {
                    String command = words[0];

                    if (command.equals("ADD-COURSE-OFFERING")) {
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
                    } else if (command.equals("REGISTER")) {
                        if (words.length >= 3) {
                            String emailId = words[1];
                            String courseId = words[2];
                            cms.registerEmployee(courseId,emailId);
                        }
                        else{
                            System.out.println(Statuses.INPUT_DATA_ERROR);
                        }
                    } else if (command.equals("CANCEL")) {
                        String courseRegistrationId = words[1];
                        cms.cancelRegistration(courseRegistrationId);
                    } else if (command.equals("ALLOT")) {
                        String courseId = words[1];
                        cms.allotCourse(courseId);
                    }
                }
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
