package com.yhh.model;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String address;
    private Integer age;

    public User(String userName, String address, Integer age) {
        this.userName = userName;
        this.address = address;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAge() {
        return age;
    }
}
