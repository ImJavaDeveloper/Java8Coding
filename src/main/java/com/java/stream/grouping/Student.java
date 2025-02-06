package com.java.stream.grouping;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student {

    private String name;
    private int roll;

    private String address;

    public Student(String name, int roll, String address) {
        this.name = name;
        this.roll = roll;
        this.address = address;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return roll == student.roll && Objects.equals(name, student.name) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roll, address);
    }

    public List<Student> studentData() {
        return Arrays.asList(new Student("Rahat", 1, "Manpur"),
                new Student("Rahul", 2, "Pune"),
                new Student("Ritesh", 2, "Pune"),
                new Student("Neha", 1, "Indore"),
                new Student("Anju", 1, "Indore"),
                new Student("Rahat", 1, "Manpur")
        );


    }
}
