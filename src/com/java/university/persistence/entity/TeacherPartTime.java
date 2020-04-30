package com.java.university.persistence.entity;

public class TeacherPartTime extends Teacher {

    private double activeHours;

    public TeacherPartTime(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public void calculateSalary() {
        double salary = getBaseSalary() * getActiveHours();
        setSalary(salary);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Part Time");
        System.out.println("Active hours: " + activeHours);
    }

    public double getActiveHours() {
        return activeHours;
    }

    public void setActiveHours(double activeHours) {
        this.activeHours = activeHours;
    }
}
