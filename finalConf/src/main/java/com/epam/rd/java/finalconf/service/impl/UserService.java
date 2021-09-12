package com.epam.rd.java.finalconf.service.impl;

import com.epam.rd.java.finalconf.entity.User;
import com.epam.rd.java.finalconf.service.UserServiceInterface;

import java.util.logging.Logger;

public class UserService implements UserServiceInterface {
    private static final Logger LOG = Logger.getLogger(UserService.class);


    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public User login(String login) {
        return null;
    }

    @Override
    public long getCount(String count, String sql) {
        return 0;
    }
}
