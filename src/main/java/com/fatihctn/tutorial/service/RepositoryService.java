package com.fatihctn.tutorial.service;

public interface RepositoryService<T, V> {
    public T findById(V id) throws Exception;
}
