package com.java.university;

import com.java.university.business.University;
import com.java.university.business.util.Input;
import com.java.university.persistence.entity.*;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        //Data Initialized
        University university = new University("Globant University");
        TeacherPartTime teacherPartTime = new TeacherPartTime("Camilo Ortiz", 30_000);
        teacherPartTime.setActiveHours(30);
        teacherPartTime.calculateSalary();
        university.addTeacher(teacherPartTime);

        Course course = new Course("History");
        course.setTeacher(teacherPartTime);
        course.setClassroom("A101");
        university.addCourse(course);

        teacherPartTime = new TeacherPartTime("Hector Villa", 28_000);
        teacherPartTime.setActiveHours(35);
        teacherPartTime.calculateSalary();
        university.addTeacher(teacherPartTime);

        course = new Course("Chemistry");
        course.setTeacher(teacherPartTime);
        course.setClassroom("A102");
        university.addCourse(course);

        TeacherFullTime teacherFullTime = new TeacherFullTime("Leonardo Donado", 2_000_000);
        teacherFullTime.setYears(3);
        teacherFullTime.calculateSalary();
        university.addTeacher(teacherFullTime);

        course = new Course("Physics");
        course.setTeacher(teacherFullTime);
        course.setClassroom("A103");
        university.addCourse(course);

        Student student = new Student("Felipe Sánchez");
        student.setId("S2");
        student.setAge(20);
        university.addStudent(student);
        student.addCourse(course);
        university.addStudent(student);


        teacherFullTime = new TeacherFullTime("Fernando Gonzalez", 2_500_000);
        teacherFullTime.setYears(5);
        teacherFullTime.calculateSalary();
        university.addTeacher(teacherFullTime);

        course = new Course("Maths");
        course.setTeacher(teacherFullTime);
        course.setClassroom("A104");
        university.addCourse(course);

        //Students Initialized

        student = new Student("Carlos Rey");
        student.setId("S1");
        student.setAge(20);
        student.addCourse(course);
        university.addStudent(student);

        student = new Student("Alejandra Rey");
        student.setId("S3");
        student.setAge(20);
        university.addStudent(student);

        student = new Student("Mauricio Acosta");
        student.setId("S4");
        student.setAge(20);
        university.addStudent(student);

        student = new Student("Julian Baquero");
        student.setId("S5");
        student.setAge(20);
        university.addStudent(student);

        student = new Student("Martín Martinez");
        student.setId("S6");
        student.setAge(20);
        university.addStudent(student);

        while (option <= 7) {
            System.out.println("*********************************");
            System.out.println("* WELCOME TO GLOBANT UNIVERSITY *");
            System.out.println("*********************************");
            System.out.println("OPTIONS");
            System.out.println("1. List Teachers");
            System.out.println("2. Print all courses");
            System.out.println("3. Create a new student");
            System.out.println("4. Create new  teacher ");
            System.out.println("5. Create new course and add teacher and student");
            System.out.println("6. List all courses from a student");
            System.out.println("7. Exit");

            option = Input.nextInt();

            switch (option) {

                case 1:
                    university.displayTeachers();
                    break;
                case 2:
                    courseMenu(university);
                    break;
                case 3:
                    university.addStudent();
                    break;
                case 4:
                    university.addTeacher();
                    break;
                case 5:
                    university.addCourse();
                    break;
                case 6:
                    university.displayStudent();
                    break;
            }

        }

    }

    public static void courseMenu(University university) {
        int option = 0;
        while (option <= 3) {
            System.out.println("1. List of courses");
            System.out.println("2. Details courses");
            System.out.println("3. Back");

            option = Input.nextInt();

            switch (option) {
                case 1:
                    university.displayCourses();
                    break;
                case 2:
                    System.out.println("Enter the course name to display");
                    String courseName = Input.next();
                    university.displayCourses(courseName);
                    break;
                case 3:
                    option = 5;
                    break;
            }
        }
    }
}
