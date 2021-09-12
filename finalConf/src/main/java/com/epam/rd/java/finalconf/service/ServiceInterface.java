package com.epam.rd.java.finalconf.service;

public interface ServiceInterface<T> {
    boolean delete(long id);
    boolean create(T entity);
}
