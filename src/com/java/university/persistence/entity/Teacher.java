package com.java.university.persistence.entity;

import com.java.university.persistence.template.Print;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.List;

public abstract class Teacher extends Common {
    private double salary;
    private double baseSalary;
    private List <Course> courseList = new ArrayList<>();

    public Teacher(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
    public void addCourse (Course course){
        this.courseList.add(course);
    }
    public abstract void calculateSalary();

    @Override
    public void displayInfo() {
        System.out.println("*************************");
        System.out.println("Teacher Information");
        System.out.println("Teacher Name: "+ getName());
        System.out.println("Salary: " + getSalary());

    }
    /* private void setCourseList(List<Course> courseList) { remove this method
        this.courseList= courseList;
    }*/
}
