package com.ktc.assignment2.lv3.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleCreate {

    @NotNull(message = "유저 아이디는 필수 값입니다.")
    private Long userId;

    @NotNull(message = "제목은 필수 값입니다.")
    private String title;

    @Size(max = 200, message = "할일은 200자 이내로 작성해주세요.")
    private String content;

    public ScheduleCreate() {
    }
}
