package com.example.integer;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

    private String number;
    private String developer;
    private String tester;
    private String hour;
    private String title;
    private String status;

    public Tasks (String number,
                  String developer,
                  String tester,
                  String hour,
                  String title,
                  String status) {
        this.number = number;
        this.developer = developer;
        this.tester = tester;
        this.hour = hour;
        this.title = title;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getTester() {
        return tester;
    }

    public String getHour() {
        return hour;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
