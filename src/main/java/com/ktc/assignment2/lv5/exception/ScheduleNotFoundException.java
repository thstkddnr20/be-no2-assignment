package com.ktc.assignment2.lv5.exception;

public class ScheduleNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "일정을 찾을 수 없습니다.";

    public ScheduleNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
