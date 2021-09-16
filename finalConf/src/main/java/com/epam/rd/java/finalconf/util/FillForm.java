package com.epam.rd.java.finalconf.util;

import javax.servlet.http.HttpServletRequest;

public class FillForm {
    public static void fillModeratorUserEditForm(HttpServletRequest request,
                                                 String firstName, String lastName, String role) {
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("role", role);
    }

    public static void fillUserCreationForm(HttpServletRequest request,
                                            String firstName, String lastName, String email) {
        request.setAttribute("first_name", firstName);
        request.setAttribute("second_name", lastName);
        request.setAttribute("email_usr", email);
    }
}
