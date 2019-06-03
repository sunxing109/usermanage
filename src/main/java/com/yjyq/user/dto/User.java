package com.yjyq.user.dto;


public class User {

    // id
    private String id;

    // 姓名
    private String name;

    // 学号
    private String stuNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", stuNumber='" + stuNumber + '\'' +
                '}';
    }
}
