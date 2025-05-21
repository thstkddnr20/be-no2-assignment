package com.ktc.assignment2.lv1.dto;

import lombok.Getter;

@Getter
public class ScheduleCreate {
    private String username;
    private String password;
    private String title;
    private String content;

    public ScheduleCreate() {
    }
}
