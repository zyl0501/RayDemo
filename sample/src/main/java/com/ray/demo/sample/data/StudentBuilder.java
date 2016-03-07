package com.ray.demo.sample.data;

public class StudentBuilder {
    private int age;
    private String name;

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Student createStudent() {
        return new Student(age, name);
    }
}