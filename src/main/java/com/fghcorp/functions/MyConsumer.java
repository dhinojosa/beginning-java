package com.fghcorp.functions;

public interface MyConsumer<T> {
    public void accept(T item);
}
