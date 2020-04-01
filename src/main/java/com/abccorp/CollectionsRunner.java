package com.abccorp;

import com.google.common.collect.*;
import com.xyzcorp.Person;

import java.util.*;

public class CollectionsRunner {
    public static void main(String[] args) {
        //CMD_SHIFT_8
        //OPT + SHIFT (multicursor)
        Person p1 = new Person("Aretha", "Franklin");
        Person p2 = new Person("Elvis", "Presley");
        Person p3 = new Person("David", "Bowie");
        Person p4 = new Person("Taylor", "Swift");
        Person p5 = new Person("Johnny", "Cash");
        Person p6 = new Person("Jimi", "Hendrix");
        Person p7 = new Person("Marvin", "Gaye");
        Person p8 = new Person("Prince", "Nelson");
        Person p9 = new Person("Willie", "Nelson");
        Person p10 = new Person("Lady", "Gaga");
        Person p11 = new Person("Garth", "Brooks");
        Person p12 = new Person("Rick", "James");

        List<Person> peopleList = new ArrayList<>();
        peopleList.add(p1);
        peopleList.add(p2);
        peopleList.add(p3);
        peopleList.add(p4);
        peopleList.add(p5);
        peopleList.add(p6);

        //Set<Person>

        Map<Person, String> map = new HashMap<>();
        map.put(p4, "Pop");
        map.put(p4, "Country");
        String genre = map.get(p4);
        System.out.println(genre);


        ListMultimap<Person, String> multimap =
            MultimapBuilder.hashKeys().arrayListValues(20).build();

        multimap.put(p4, "Pop");
        multimap.put(p4, "Country");

        System.out.println(multimap.get(p4));


        Comparator<Person> sortByFirstName = (o1, o2) ->
            o1.getFirstName().compareTo(o2.getFirstName());

        Comparator<Person> sortByLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        };

        Collections.sort(peopleList, sortByLastName);

        System.out.println(peopleList);
    }
}
