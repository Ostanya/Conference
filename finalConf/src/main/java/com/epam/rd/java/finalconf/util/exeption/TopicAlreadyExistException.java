package com.epam.rd.java.finalconf.util.exeption;

public class TopicAlreadyExistException extends RuntimeException {
    public TopicAlreadyExistException() {super();}
    public TopicAlreadyExistException(String m) {super(m);}
    public TopicAlreadyExistException(String m, Throwable t) {super(m, t);}
}
