package com.kp.collectionstest;

public class Clerk extends Employee {

    public Clerk(String name, String surname, double salary, int age, String occupation) {
        super(name, surname, salary, age);
        this.occupation = occupation;

    }

    public double getSalary() {
        return getBaseSalary() *getMultiplicator();
    }

    protected double getMultiplicator() {
        return 1.23;
    }
}
