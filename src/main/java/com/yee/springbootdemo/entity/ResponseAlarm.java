package com.yee.springbootdemo.entity;

public class ResponseAlarm extends BaseAlarm{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResponseAlarm{" +
                "id=" + id +
                ",alarm_type=" + getAlarm_type() +
                ",alarm_level=" + getAlarm_level() +
                ",alarm_content=" + getAlarm_content() +
                '}';
    }
}
