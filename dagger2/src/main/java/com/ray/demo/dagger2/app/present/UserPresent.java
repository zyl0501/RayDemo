package com.ray.demo.dagger2.app.present;

import com.ray.demo.dagger2.app.model.User;

import javax.inject.Inject;

public class UserPresent {

    private String info;

    @Inject
    public UserPresent() {
        info = "User Present @Inject default constructor generate";
    }

    public UserPresent(String info){
        this.info = info;
    }

    public User getUser(String name){
        return new User(name, 0);
    }

    public String getInfo() {
        return info;
    }
}
