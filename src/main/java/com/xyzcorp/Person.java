package com.xyzcorp;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName,
                  Optional<LocalDate> birthday) {
        this(firstName, lastName);
        checkThatBirthdayIsNotInFuture(birthday);
        this.birthday = birthday.orElse(null);
    }

    protected void checkThatBirthdayIsNotInFuture(Optional<LocalDate> birthday) {
        birthday //Optional<LocalDate>
                 .map(bd -> bd.isAfter(LocalDate.now())) //Optional<Boolean>
                 .ifPresent(b -> {
                     if (b)
                         throw new IllegalArgumentException("Birthday cannot " +
                             "be in the future");
                 });
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
            Period.between(localDate, LocalDate.now()).getYears());
    }
}
