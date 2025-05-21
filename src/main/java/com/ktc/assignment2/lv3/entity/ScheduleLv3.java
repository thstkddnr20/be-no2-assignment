package com.ktc.assignment2.lv3.entity;

import java.time.LocalDateTime;

//lv3 entity
public class ScheduleLv3 {

    private Long id; //PK
    private Long userId; //User FK

    private String title;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
