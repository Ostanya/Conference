package com.epam.rd.java.finalconf.util;

public class Resolver {
    public static String resolve(String page) {
        return String.format("/WEB-INF/view/%s.jsp", page);
    }

    public static String resolveAdmin(String page) {
        return String.format("/WEB-INF/view/admin/%s.jsp", page);
    }

}
