package com.fghcorp;

import com.fghcorp.functions.Functions;
import com.fghcorp.functions.MyFunction;

import java.util.Arrays;
import java.util.List;

public class TaxRate {
    private final int year;
    private final double taxRate;

    public TaxRate(int year, double taxRate) {
        this.year = year;
        this.taxRate = taxRate;
    }

    public double apply(int subtotal) {
        return (subtotal * taxRate) + subtotal;
    }

    //Getters, toString, equals elided

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 1, 9, 15, 19,
            21, 33, 78, 93, 10);

        TaxRate taxRate2016 = new TaxRate(2016, .085);

        System.out.println(Functions.myMap(numbers,
            subtotal -> taxRate2016.apply(subtotal)));
    }
}
