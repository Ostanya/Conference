package com.epam.rd.java.finalconf.service;

import com.epam.rd.java.finalconf.entity.User;

public interface UserServiceInterface extends ServiceInterface {
    User login(String login);
    long getCount(String count, String sql);
}
