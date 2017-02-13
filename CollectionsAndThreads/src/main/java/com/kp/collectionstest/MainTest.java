package com.kp.collectionstest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        Employee clerk = new Clerk("Jan","Kowalski",10,25,"Magazynier");
        Employee secretary = new Secretary("Maria","Nowak",10,45,"Sekretarka");
        Employee manager = new Manager("Jan","Kowalski",100,55,"Manager");

        List<Employee> list = new ArrayList<Employee>();
        list.add(clerk);
        list.add(secretary);
        list.add(manager);

        for (Employee e: list) {
            System.out.println(e.getOccupation()+": "+e.getSalary());
        }
        
        User one = new User("Jan","Kowalski,",45);
        User two = new User("Jan","Kowalski,",45);
        User three = new User("Jan","Kowalski,",45);

        Set<User> users = new HashSet<User>();
        users.add(new User("Roman","Kowalski,",5));
        users.add(new User("Andrzej","Nowak,",12));
        users.add(new User("Adam","Adamiak,",6));
        System.out.println(users.size());

        for (User u:users) {
            System.out.println(u.hashCode());
        }

        users.add(null);
        System.out.println(users.size());
        ArrayList<User> arlist = new ArrayList<User>();
        arlist.add(new User("Roman", "Kowalski,", 5));
        arlist.add(new User("Andrzej", "Nowak,", 12));
        arlist.add(new User("Adam", "Adamiak,", 6));
        Collections.sort(arlist);

        for (User u : arlist) {
            System.out.println(u.surname);
        }
        Collections.sort(arlist, User.AGE_COMPARATOR);

        for (User u : arlist) {
            System.out.println(u.surname);
        }

        List<String> lista= new ArrayList<String>();
        lista.add("12");
        lista.add("3");
        lista.add("4");
        lista.add("35");
        lista.add("5");
        lista.add("1");
        lista.add("99");
        lista.add("55");
        lista.add("45");
        lista.add("0");

        long count = lista.stream().map(Integer::parseInt).filter(b->b>10).count();
        System.out.println(count);

    }


}


