package com.abccorp;

import com.xyzcorp.Person;

class Runner {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Person person = Person.of("James", "Gosling");
        System.out.println(person);
    }
}
