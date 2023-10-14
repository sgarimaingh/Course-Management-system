
# Context
This is the solution of a coding challenge called Course Scheduling on the GeekTrust platform.
```
https://www.geektrust.com/challenge/course-scheduling?utm_campaign=atwc&utm_content=atwc&utm_medium=email&utm_source=product
```

# Problem Statement
The head of the Learning management system (LMS) has hired you as a consultant. The LMS team has the goal of upskilling the employees with the latest topics via courses. You need to help build a system to schedule and manage the courses.
Build a simple command line application, which does the following:

```
1. Add course offering
   A course offering has course title, instructor and date.
   It should also contain a minimum & maximum number of employees for the course offering.
   
2. Register for the course
   Employees can register for the courses.
   If no. of employees registered for the course has reached the maximum, the result will be COURSE_FULL_ERROR.
   Otherwise, result of registration will be ACCEPTED.
   
3. Cancel registration
   Employees can cancel their registration until the course allotment is completed.
   
4. Course allotment
   This feature allots employees to course offering, before the course offering date.
   It should print a list of all the employees with their details along with their final course allotment status (Registration Number, Employee Name, Email, Course Offering ID, Course Name, Instructor, Date, Final Status). The list should be sorted based on the Registration number.
   If sufficient registrations are not received then the course offering itself gets cancelled.
   The employees who have registered will get confirmed unless the minimum number of registrations is not received.
   Even if the course offering gets canceled due to the minimum number of employees not registered, the list should be printed.
```

# Sample Input and Output
INPUT
```
ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3
REGISTER WOO@GMAIL.COM OFFERING-PYTHON-JOHN
REGISTER ANDY@GMAIL.COM OFFERING-PYTHON-JOHN
REGISTER BOBY@GMAIL.COM OFFERING-PYTHON-JOHN
CANCEL REG-COURSE-BOBY-PYTHON
ALLOT OFFERING-PYTHON-JOHN
```

OUTPUT
```agsl
OFFERING-PYTHON-JOHN
REG-COURSE-WOO-PYTHON ACCEPTED
REG-COURSE-ANDY-PYTHON ACCEPTED
REG-COURSE-BOBY-PYTHON ACCEPTED
REG-COURSE-BOBY-PYTHON CANCEL_ACCEPTED
REG-COURSE-ANDY-PYTHON ANDY@GMAIL.COM OFFERING-PYTHON-JOHN  PYTHON  JOHN 05062022 CONFIRMED
REG-COURSE-WOO-PYTHON WOO@GMAIL.COM OFFERING-PYTHON-JOHN  PYTHON  JOHN  05062022 CONFIRMED
```
# Pre-requisites
* Java 1.8
* Gradle 6

# How to run the code

We have provided scripts to execute the code. 

Use `run.sh` if you are Linux/Unix/macOS Operating systems. The file runs the command and prints only output from the input file `sample_input/input1.txt`. You are supposed to add the input commands in the file from the appropriate problem statement. 


 We expect your program to take the location to the text file as parameter. Input needs to be read from a text file, and output should be printed to the console. The text file will contain only commands in the format prescribed by the respective problem.

 Use the build.gradle file provided along with this project. Please change the main class entry under the `jar` task

 ```
 manifest {
        attributes 'Main-Class' : 'com.example.geektrust.Main' //Change this to the main class of your program which will be executed
    }
```
in the build.gradle if your main class has changed.

 # How to execute the unit tests

 `gradle clean test --no-daemon` will execute the unit test cases.


