package com.yhh.model;

public class User {

    private String userName;

    private String address;

    private Integer age;

    public User() {
    }

    public User(String userName, String address, Integer age) {
        this.userName = userName;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "userName is " + userName +
                "; address is " + address +
                "; age is " + age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
