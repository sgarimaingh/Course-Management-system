package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProcessCommands pc = new ProcessCommands();
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
                            pc.processAddOfferingCommand(words);
                            break;
                        case "REGISTER":
                            pc.processRegisterCommand(words);
                            break;
                        case "CANCEL":
                            pc.processCancelRegistrationCommand(words);
                            break;
                        case "ALLOT":
                            pc.processAllotCommand(words);
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
}
