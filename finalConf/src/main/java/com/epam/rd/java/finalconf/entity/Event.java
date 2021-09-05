package com.epam.rd.java.finalconf.entity;

public class Event {
    private int id;
    private String eventName;
    private String topic;
    private User user;

    private static int counter = 1;
  //  private Date date;

    public Event() {
        id = counter++;
    }
    public Event(String eventName, String topic) {
        id = counter++;
        this.eventName = eventName;
        this.topic = topic;
       // this.user = user;
    }


    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

   // public User getUser() {
//        return user;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", topic='" + topic + '\'' +
                ", user=" + user +
                '}';
    }
}
