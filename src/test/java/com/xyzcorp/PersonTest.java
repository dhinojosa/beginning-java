package com.xyzcorp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testPersonFirstName() {
        Person person = new Person("James", "Gosling");
        assertEquals(person.getFirstName(), "James");
    }

    @Test
    public void testPersonLastName() {
        Person person = new Person("James", "Gosling");
        assertEquals(person.getLastName(), "Gosling");
    }


    @Test
    public void testToString() {
        Person person = new Person("James", "Gosling");
        assertEquals("Person[firstName='James', lastName='Gosling']", person.toString());
    }

    @Test
    public void testEquals() {
        Person person1 = new Person("James", "Gosling");
        Person person2 = new Person("James", "Gosling");
        assertEquals(person1, person2);
    }

    @Test
    public void testHashCode() {
        Person person1 = new Person("James", "Gosling");
        Person person2 = new Person("James", "Gosling");
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void testBirthday() {
        //CMD+OPT+N = Inline
        Optional<LocalDate> expectedBirthday = Optional.of(LocalDate.of(1955, 5, 19));
        Person person = new Person("James", "Gosling", expectedBirthday);
        Optional<LocalDate> actualBirthday = person.getBirthday();
        assertEquals(actualBirthday, expectedBirthday);
    }

    @Test
    public void testAge() {
        Optional<LocalDate> expectedBirthday = Optional.of(LocalDate.of(1955, 5, 19));
        Person person = new Person("James", "Gosling", expectedBirthday);
        assertEquals(Optional.of(64), person.getAge());
    }

    @Test
    public void testAgeWithNoBirthday() {
        Optional<LocalDate> expectedBirthday = Optional.empty();
        Person person = new Person("James", "Gosling", expectedBirthday);
        assertEquals(Optional.empty(), person.getAge());
    }

    @Test
    public void testBirthdayIsNotInFuture() {
        Optional<LocalDate> expectedBirthday = Optional.of(LocalDate.of(2040, 1, 10));
        try {
            new Person("James", "Gosling", expectedBirthday);
            fail("This should never happen");
        } catch (IllegalArgumentException iae) {
            assertEquals("Birthday cannot be in the future", iae.getMessage());
        }
    }
}

