package com.fghcorp.functions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Functions {
    public static <T> List<T> myFilter (List<T> list, MyPredicate<T> predicate) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T, R> List<R> myMap(List<T> list, MyFunction<T, R> myFunction) {
        ArrayList<R> result = new ArrayList<>();
        for (T t : list) {
            R apply = myFunction.apply(t);
            result.add(apply);
        }
        return result;
    }

    public static <T, R> List<R> myFlatMap(List<T> list, MyFunction<T, List<R>> myFunction) {
        ArrayList<R> result = new ArrayList<>();
        for (T t : list) {
            List<R> application = myFunction.apply(t);
            result.addAll(application);
        }
        return result;
    }

    public static <T> void myForEach(List<T> list, MyConsumer<T> myConsumer) {
        for (T t : list) {
            myConsumer.accept(t);
        }
    }

    public static <T> List<T> myGenerate(MySupplier<T> supplier, int count) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(supplier.get());
        }
        return result;
    }

    public static <T> List<T> myBadGenerate(T thing, int count) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(thing);
        }
        return result;
    }

    public static void main(String[] args) {

        //filter
        List<Integer> ints = List.of(40, 23, 11, 10, 3);
        //CMD+OPT+V = Intro a var
        //CMD+W = Increase cursor
        //Opt+UP, Opt+DOWN

        List<Integer> integers = Functions.myFilter(ints, item -> item % 2 == 0);
//        System.out.println(integers);


        //map
        List<Integer> ints2 = List.of(40, 23, 11, 10, 3);
        List<Integer> listAfterMap = Functions.myMap(ints2, integer -> integer + 3);
        System.out.println(listAfterMap);

        List<String> strings = List.of("New York", "Texas", "California",
            "Kansas", "New Jersey");

        List<Integer> integers1 = Functions.myMap(strings, String::length);

        System.out.println(integers1);

        //flatMap - MAGICAL!!!!
        List<Integer> ints3 = List.of(1,2,3);
        List<Integer> lists = Functions.myFlatMap(ints3, i -> List.of(-i, i, i + 1));
        System.out.println(lists);


        //foreach
        List<Integer> ints4 = List.of(40, 23, 11, 10, 3);
        Functions.myForEach(ints4, System.out::println);


        //good generate
        List<LocalDateTime> localDateTimes =
            Functions.myGenerate(LocalDateTime::now, 10);
        System.out.println(localDateTimes);

        //bad generate
        List<LocalDateTime> localDateTimes2 =
            Functions.myBadGenerate(LocalDateTime.now(), 10);
        System.out.println(localDateTimes2);

        Thread t = new Thread(() -> {
            String threadName =
                Thread.currentThread().getName();
            System.out.format("%s: %s%n",
                threadName,
                "Hello from another thread");
        });
        t.start();
    }
}
