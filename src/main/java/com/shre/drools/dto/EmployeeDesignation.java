package com.shre.drools.dto;

public class EmployeeDesignation {

    String name="defaultName";
    String designation="defaultDesignation";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        System.out.println("designation "+ designation);
        this.designation = designation;
    }


    @Override
    public String toString() {
        return "name: "+name+ " and designation: "+designation;
    }
}
