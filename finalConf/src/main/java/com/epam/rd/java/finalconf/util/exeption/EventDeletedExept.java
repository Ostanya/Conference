package com.epam.rd.java.finalconf.util.exeption;

public class EventDeletedExept extends RuntimeException {
    public EventDeletedExept() {
        super();
    }

    public EventDeletedExept(String message) {
        super(message);
    }

    public EventDeletedExept(String message, Throwable cause) {
        super(message, cause);
    }
}
