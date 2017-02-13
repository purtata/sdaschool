package com.kp.collectionstest;

public class Secretary extends Employee {

    public Secretary(String name, String surname, double salary, int age, String occupation) {
        super(name, surname, salary, age);
        this.occupation = occupation;
    }

    public double getSalary() {
        return getBaseSalary()+getMultiplicator();
    }

    protected double getMultiplicator() {
        return 10;
    }

}

