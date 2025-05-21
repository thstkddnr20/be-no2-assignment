package com.ktc.assignment2.lv1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleLv1Dto {
    private String username;
    private String title;
    private String content;


    public ScheduleLv1Dto(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public ScheduleLv1Dto() {
    }
}
