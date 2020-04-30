package com.java.university.persistence.entity;

import java.util.ArrayList;
import java.util.List;

public class Student extends Common {
    private String id;
    private int age;
    private List<Course> courseList = new ArrayList<>();

    public Student(String name) {
        super(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
        course.addStudent(this);
    }

    @Override
    public void displayInfo() {
        System.out.println("********************");
        System.out.println("Student Name: "+ getName());
        System.out.println("Id: "+ getId());
        System.out.println("Age: "+ getAge());

    }
}
