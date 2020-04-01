package com.xyzcorp;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Supplier;

public class Person {
    private Supplier<LocalDate> nowSupplier;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName,
                  String lastName,
                  LocalDate birthday,
                  Supplier<LocalDate> now) {
        this(firstName, lastName);
        this.birthday = birthday;
        this.nowSupplier = now;
    }

    public static Person of(String firstName, String lastName,
                            LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Birthday cannot " +
                "be in the future");
        return new Person(firstName, lastName, birthday, () -> LocalDate.now());
    }

    public static Person of(String firstName, String lastName) {
        return new Person(firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
            Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
            .add("firstName='" + firstName + "'")
            .add("lastName='" + lastName + "'")
            .toString();
    }

    public Optional<LocalDate> getBirthday() {
        return Optional.ofNullable(birthday);
    }

    public Optional<Integer> getAge() {
        return getBirthday().map(localDate ->
            Period.between(localDate, nowSupplier.get()).getYears());
    }
}
