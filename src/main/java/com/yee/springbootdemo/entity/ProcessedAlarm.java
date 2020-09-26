package com.yee.springbootdemo.entity;

public class ProcessedAlarm extends BaseAlarm{
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ProcessedAlarm{" +
                "lng=" + location.lng +
                ",lat=" + location.lat +
                ",alarm_type=" + getAlarm_type() +
                ",alarm_level=" + getAlarm_level() +
                ",alarm_content=" + getAlarm_content() +
                '}';
    }
}
