package com.ktc.assignment2.lv1;

import com.ktc.assignment2.lv1.dto.ScheduleCreate;
import com.ktc.assignment2.lv1.dto.ScheduleLv1Dto;
import com.ktc.assignment2.lv5.exception.ScheduleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceLv1 {

    private final RepositoryLv1 repository;

    public void create(ScheduleCreate dto) {
        repository.save(dto);
    }

    public List<ScheduleLv1Dto> searchAll(String start, String end, String username) {
        return repository.findAll(LocalDate.parse(start), LocalDate.parse(end), username);
    }

    public ScheduleLv1Dto search(Long id) {
        Optional<ScheduleLv1Dto> dto = repository.findById(id);
        return dto.orElseThrow(ScheduleNotFoundException::new);
    }
}
