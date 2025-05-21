package com.ktc.assignment2.lv1.entity;

import lombok.Getter;

import java.time.LocalDateTime;

//lv1 entity
@Getter
public class ScheduleLv1 {

    private Long id;
    private String username;
    private String password;
    private String title;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public ScheduleLv1(Long id, String username, String password, String title, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ScheduleLv1() {
    }
}
