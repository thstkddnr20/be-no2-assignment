package com.ktc.assignment2.lv3;

import com.ktc.assignment2.lv3.dto.ScheduleCreate;
import com.ktc.assignment2.lv3.dto.ScheduleLv3Dto;
import com.ktc.assignment2.lv3.dto.UserAdd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLv3 {

    private final RepositoryLv3 repository;

    public List<ScheduleLv3Dto> searchAll(String start, String end, Long userId) {
        return repository.findAll(LocalDate.parse(start), LocalDate.parse(end), userId);
    }

    public void create(ScheduleCreate createDto) {
        repository.createSchedule(createDto);
    }

    public void addUser(UserAdd userAdd) {
        repository.addUser(userAdd);
    }

}
