package com.fghcorp;

import com.fghcorp.functions.Functions;
import com.fghcorp.functions.MyPredicate;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.time.temporal.ChronoUnit.YEARS;

public class ClosureExample {

    public static Integer foo
        (Function<Integer, Integer> f) {
        return f.apply(5);
    }

    public void otherMethod() {
        final Integer x = 3;
        Function<Integer, Integer> add3 = z -> x + z;
        System.out.println(foo(add3));
    }

    public static MyPredicate<String> stringHasSizeOf(final int length) {
        return item -> item.length() == length;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Foo", "Ramen", "Naan", "Ravioli");
        System.out.println(Functions.myFilter(names, stringHasSizeOf(4)));
        System.out.println(Functions.myFilter(names, stringHasSizeOf(2)));
        System.out.println(YEARS.between(LocalDate.of(2017, 3, 1),
            LocalDate.now()));

        Period age = Period.between(LocalDate.of(2017, 3, 1), LocalDate.now());
        System.out.println(Optional.of(age.getYears()));
    }


}
