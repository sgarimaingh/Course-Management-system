package com.example.geektrust;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    private CourseManagementSystem cms;

    @Before
    public void setUp() {
        cms = new CourseManagementSystem();
    }

    @Test
    public void testAddCourseOffering() {
        String courseTitle = "Java";
        String instructor = "James";
        String date = "05062022";
        int minEmployees = 1;
        int maxEmployees = 2;

        // Save the initial size of the course offerings list
        int initialSize = cms.getCourseOfferings().size();

        CourseOffering newCourse = new CourseOffering(courseTitle, instructor, date, minEmployees, maxEmployees);
        cms.addCourseOffering(newCourse);

        CourseOffering addedCourse = cms.getCourseOfferings().get(initialSize);

        String expectedCourseId = "OFFERING-Java-James";
        assertEquals(expectedCourseId, addedCourse.getCourseId());

    }

    @Test
    public void testRegisterEmployeeAccepted() {
        // Mock course offering
        CourseOffering courseOffering = new CourseOffering("Java", "James", "05062022", 1, 20);
        courseOffering.setCourseId("OFFERING-Java-James");
        cms.getCourseOfferings().add(courseOffering);

        String emailId = "test@gmail.com";
        String courseId = "OFFERING-Java-James";
        cms.registerEmployee(courseId, emailId);

        Employee employee = cms.getEmployees().get(0);
        assertEquals(Statuses.ACCEPTED, employee.getCourseStatus());
        assertEquals("REG-COURSE-test-Java", employee.getRegistrationNumber());
    }

    @Test
    public void testAllotCourse() {
        // Mock course offering
        CourseOffering courseOffering = new CourseOffering("Java", "James", "05062022", 1, 20);
        courseOffering.setCourseId("OFFERING-Java-James");
        cms.getCourseOfferings().add(courseOffering);

        // Mock employee with an accepted registration
        Employee employee = new Employee("Woo", "Woo@example.com");
        employee.setCourseStatus(Statuses.ACCEPTED);
        employee.setRegistrationNumber("REG-COURSE-Woo-Java");

        // Added employee to cms's employees list
        cms.getEmployees().add(employee);

        String courseId = "OFFERING-Java-James";
        cms.allotCourse(courseId);

        assertEquals(Statuses.CONFIRMED, employee.getCourseStatus());
    }

    @Test
    public void testCancelRegistrationAccepted() {
        // Mock employee with an accepted registration
        Employee employee = new Employee("Woo", "Woo@example.com");
        employee.setCourseStatus(Statuses.ACCEPTED);
        employee.setRegistrationNumber("REG-COURSE-Woo-Java");

        // Added employee to cms's employees list
        cms.getEmployees().add(employee);

        String courseRegistrationId = "REG-COURSE-Woo-Java";
        cms.cancelRegistration(courseRegistrationId);

        assertEquals(Statuses.CANCEL_ACCEPTED, employee.getCourseStatus());
    }


}
