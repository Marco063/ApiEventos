package com.edu.uptc.apieventos.entities;

public class EventUserRequest {
    private Event event;
    private User user;

    public EventUserRequest() {
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
