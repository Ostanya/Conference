package com.epam.rd.java.finalconf.dao;

import com.epam.rd.java.finalconf.entity.User;

import java.util.Optional;

public interface UDao extends MainDao<User> {
    Optional<User> findByUserEmail(String email);
    boolean deleteByUserId(long id);
    Optional<User> updateRole(User user);
}
