package com.epam.rd.java.finalconf.util.exeption;

public class EventNotFoundExept extends RuntimeException {
    public EventNotFoundExept() {
        super();
    }
    public EventNotFoundExept(String message) {
        super(message);
    }
    public EventNotFoundExept(String message, Throwable c) {
        super(message, c);
    }
}
