package com.ktc.assignment2.lv4.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleLv4Dto {

    private String username;

    private String title;
    private String content;


    public ScheduleLv4Dto(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
