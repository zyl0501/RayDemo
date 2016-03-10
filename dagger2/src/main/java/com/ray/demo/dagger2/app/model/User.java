package com.ray.demo.dagger2.app.model;

/**
 * Created by Ray on 16/3/7.
 */
public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
