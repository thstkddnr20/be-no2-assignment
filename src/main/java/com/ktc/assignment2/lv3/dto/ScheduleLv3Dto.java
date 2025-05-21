package com.ktc.assignment2.lv3.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleLv3Dto {

    private String title;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ScheduleLv3Dto(String title, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
