package com.example.database;

import java.io.IOException;

public class Person {
    private String name;
    private int age;
    private int number;
    private int money;

    Person(){
        this.name = "Федор";
        this.age = 24;
        this.number = 232232;
        this.money = 29000;
    }

    Person(String name, int age, int number, int money) throws IOException {
        setParams(name,age,number,money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IOException {
        if(age > 0)
        this.age = age;
        else
            throw new IOException("Age cant be less then 0!");
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number) throws IOException {
        if(number > 0)
        this.number = number;
        else
            throw new IOException("Number cant be less then 0!");
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) throws IOException {
        if(money >= 0)
        this.money = money;
        else
            throw new IOException("Number cant be less then 0!");
    }

    public void setParams(String name, int age, int number, int money) throws IOException {
        setName(name);
        setMoney(money);
        setNumber(number);
        setAge(age);
    }

    public String toString(){
        return getName() + ", " + getAge() + ", " + getMoney() + ", " + getNumber();
    }

}
