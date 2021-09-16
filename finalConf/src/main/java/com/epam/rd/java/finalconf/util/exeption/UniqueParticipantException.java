package com.epam.rd.java.finalconf.util.exeption;

public class UniqueParticipantException extends RuntimeException {
    public UniqueParticipantException() {super();}
    public UniqueParticipantException(String m) {super(m);}

    public UniqueParticipantException(String m, Throwable t) {super(m, t);}
}
