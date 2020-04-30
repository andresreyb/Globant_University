package com.java.university.persistence.entity;

import com.java.university.persistence.template.Print;

public class TeacherFullTime extends Teacher {

    private int years;

    public TeacherFullTime(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public void calculateSalary() {
        double salary = getBaseSalary() * (1.1 * getYears());
        setSalary(salary);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Full Time" );
        System.out.println("Years: "+ years );
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
