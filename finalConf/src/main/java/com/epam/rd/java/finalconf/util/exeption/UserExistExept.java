package com.epam.rd.java.finalconf.util.exeption;

public class UserExistExept extends RuntimeException{
    public UserExistExept() {}
    public UserExistExept(String mesg) {super(mesg);}
}
