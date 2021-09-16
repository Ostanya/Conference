package com.epam.rd.java.finalconf.util.exeption;

public class EventExistExept extends RuntimeException{

    public EventExistExept() {
        super();
    }

    public EventExistExept(String message) {
        super(message);
    }

    public EventExistExept(String message, Throwable cause) {
        super(message, cause);
    }
}
