package com.fghcorp.functions;

public interface MyFunction<T, R> {
    public R apply(T t);
}
