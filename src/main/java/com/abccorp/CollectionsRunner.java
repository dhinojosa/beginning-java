package com.abccorp;

import com.google.common.collect.*;
import com.xyzcorp.Person;

import java.util.*;

public class CollectionsRunner {
    public static void main(String[] args) {
        //CMD_SHIFT_8
        //OPT + SHIFT (multicursor)
        Person p1 = Person.of("Aretha", "Franklin");
        Person p2 = Person.of("Elvis", "Presley");
        Person p3 = Person.of("David", "Bowie");
        Person p4 = Person.of("Taylor", "Swift");
        Person p5 = Person.of("Johnny", "Cash");
        Person p6 = Person.of("Jimi", "Hendrix");
        Person p7 = Person.of("Marvin", "Gaye");
        Person p8 = Person.of("Prince", "Nelson");
        Person p9 = Person.of("Willie", "Nelson");
        Person p10 = Person.of("Lady", "Gaga");
        Person p11 = Person.of("Garth", "Brooks");
        Person p12 = Person.of("Rick", "James");

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
