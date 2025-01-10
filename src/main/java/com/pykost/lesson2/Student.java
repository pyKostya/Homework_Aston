package com.pykost.lesson2;


public class Student implements Comparable<Student> {
    private final int id;
    private final String name;
    private final String surname;

    public Student(int id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surname = surName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Student obj) {
        return this.id - obj.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surname + '\'' +
                '}';
    }
}
