package com.epam.rd.java.finalconf.dao;

import java.util.List;
import java.util.Optional;

public interface MainDao<T> {

    Optional<T> update(T t);
    Optional<T> findById(long id);
    Optional<T> delete(T t);
    List<T> findAll();
    Optional<T> save(T t);
}
