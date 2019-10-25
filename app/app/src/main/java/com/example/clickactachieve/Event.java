package com.example.clickactachieve;

import java.sql.Time;
import java.util.Date;

public class Event {
    private String name;
    private String description;
    private String location;
    private int eventType; //0-physical, 1-arts, 2-recreation

    public static int PHYSICAL = 0;
    public static int ARTS = 1;
    public static int LEARN = 2;
    public static int VOLUNTEER = 3;

    public Event(String name, String description, String location, int eventType) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
