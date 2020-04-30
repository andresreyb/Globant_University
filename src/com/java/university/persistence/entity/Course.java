package com.java.university.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Course extends Common {
    private String classroom;
    private Teacher teacher;
    private List <Student> studentList = new ArrayList<>();
    public Course(String name) {
        super(name);
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    @Override
    public void displayInfo() {
        System.out.println("*************************");
        System.out.println("Course Name: " + getName());
        System.out.println("Classroom: " + getClassroom());
    }
}
