package com.epam.rd.java.finalconf.dto;

public class EventRegistration {
    private String nickName;
    private Boolean isSpeaker;

    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public Boolean getSpeaker() {
        return isSpeaker;
    }
    public void setSpeaker(Boolean speaker) {
        isSpeaker = speaker;
    }
}
