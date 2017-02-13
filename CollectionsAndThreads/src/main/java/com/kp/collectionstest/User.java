package com.kp.collectionstest;
import java.util.Comparator;


public class User implements Comparable<User>{
    String name, surname;
    int age;

    public static Comparator<User> AGE_COMPARATOR= new Comparator<User>(){

        public int compare(User o1, User o2) {
            return o1.age -o2.age;
        }
    };

    public User (String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return surname != null ? surname.equals(user.surname) : user.surname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        if (name.substring(0,1).equalsIgnoreCase("A")) return 1234;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    public int compareTo(User o) {
        return surname.compareTo(o.surname);

    }
}
