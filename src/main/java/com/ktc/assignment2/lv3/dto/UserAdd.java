package com.ktc.assignment2.lv3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserAdd {

    private String name;

    @NotBlank(message = "비밀번호는 필수 값입니다.")
    private String password;

    @Email(message = "이메일 형태가 잘못되었습니다.")
    private String email;

    public UserAdd() {
    }
}
