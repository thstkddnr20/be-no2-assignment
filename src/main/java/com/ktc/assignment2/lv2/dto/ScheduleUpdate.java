package com.ktc.assignment2.lv2.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdate {

    private Long id;
    private String username;
    private String password;
    private String content;

    public ScheduleUpdate() {
    }
}
