package com.kp.collectionstest;

public abstract class Employee {

    private String name, surname;
    private double salary;
    private int age;
    protected String occupation="";

    public Employee(String name, String surname, double salary, int age) {
        this.name = name;
        this.surname = surname ;
        this.salary = salary;
        this.age = age;
    }

    protected abstract double getSalary();
    protected abstract double getMultiplicator();

    public double getBaseSalary(){
        return salary;
    }

    public String getOccupation() {
        return occupation;
    }
}
