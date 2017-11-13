package com.knight.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String sex;

    private String homeAdd;

    public Person() {
    }

    public Person(String name, String sex, String homeAdd) {
        this.name = name;
        this.sex = sex;
        this.homeAdd = homeAdd;
    }

    public String getHomeAdd() {
        return homeAdd;
    }

    public void setHomeAdd(String homeAdd) {
        this.homeAdd = homeAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "[ name = " + this.name + " , sex = " + this.sex + ", homeAdd = " + this.homeAdd +"]" ;
    }
}
