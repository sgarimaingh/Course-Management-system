package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CourseRegistration app = new CourseRegistration();

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");

                if (parts.length > 0) {
                    String command = parts[0];

                    if (command.equals("ADD-COURSE-OFFERING")) {
                        if (parts.length >= 6) {
                            String courseTitle = parts[1];
                            String instructor = parts[2];
                            String date = parts[3];
                            int minEmployees = Integer.parseInt(parts[4]);
                            int maxEmployees = Integer.parseInt(parts[5]);
                            app.addCourseOffering(courseTitle, instructor, date, minEmployees, maxEmployees);
                            app.print();
                        }
                        else {
                            System.out.println(Constants.INPUT_DATA_ERROR);
                        }
                    } else if (command.equals("REGISTER")) {
                        // Handle registration command
                        // Parse and process registration details
                    } else if (command.equals("CANCEL")) {
                        // Handle cancellation command
                        // Parse and process cancellation details
                    } else if (command.equals("COURSE-ALLOTMENT")) {
                        // Handle course allotment command
                        // Perform course allotment and print the final list
                    }
                }
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
