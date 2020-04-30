package com.java.university.persistence.entity;

import com.java.university.persistence.template.Print;

public abstract class Common implements Print {
    private String name;

    public Common(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
