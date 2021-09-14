package com.epam.rd.java.finalconf.service.impl;

import com.epam.rd.java.finalconf.entity.Role;
import com.epam.rd.java.finalconf.entity.User;
import it.cosenonjaviste.crypto.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Secutiry {
    public User getLoggedUser(HttpSession session) {
        return (User) session.getAttribute("loggedUser");
    }

    public void storeLoggedUser(HttpSession session, User user) {
        session.setAttribute("loggedUser", user);
    }

    public String setUriByRole(HttpServletRequest request) {
        User user = getLoggedUser(request.getSession());
        if (user.getRole() == Role.MODERATOR) {
            return "/event/all";
        }
        return "/index";
    }

    public boolean passwordIsValid(String candidate, User user) {
        return BCrypt.checkpw(candidate, user.getPassword());
    }

    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
}
