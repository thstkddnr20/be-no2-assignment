package com.ktc.assignment2.lv5.exception;

public class PasswordInvalidException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "비밀번호가 잘못되었습니다.";

    public PasswordInvalidException() {
        super(DEFAULT_MESSAGE);
    }
}
