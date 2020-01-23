package com.fatihctn.tutorial.util;

public interface Calculator<T, V> {
    public abstract V calculateFor(T item);
}
