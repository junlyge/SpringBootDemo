package com.lj.test.demo.model;

public class User {
    private String name;
    private String password;
    private String department;
    private Integer age;
    private String address;

    public User() {}

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User(String name, String password,String department, Integer age, String address) {
        this.name = name;
        this.password = password;
        this.department = department;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
