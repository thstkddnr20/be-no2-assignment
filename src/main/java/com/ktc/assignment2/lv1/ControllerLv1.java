package com.ktc.assignment2.lv1;

import com.ktc.assignment2.lv1.dto.ScheduleLv1Dto;
import com.ktc.assignment2.lv1.entity.ScheduleLv1;
import com.ktc.assignment2.lv1.dto.ScheduleCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lv1")
public class ControllerLv1 {

    private final ServiceLv1 service;

    @PostMapping("/schedule")
    public ResponseEntity<ScheduleLv1> create(@RequestBody ScheduleCreate createDto) {
        service.create(createDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/schedule/jdbctemplate")
    public ResponseEntity<Long> createWithJdbcTemplate(@RequestBody ScheduleCreate createDto) {
        Long id = service.createWithJdbcTemplate(createDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleLv1Dto>> searchAll(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam String username) {
        List<ScheduleLv1Dto> list = service.searchAll(start, end, username);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/schedule/jdbctemplate")
    public ResponseEntity<List<ScheduleLv1Dto>> searchAllWithJdbcTemplate(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam String username) {
        List<ScheduleLv1Dto> list = service.searchAllWithJdbcTemplate(start, end, username);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<ScheduleLv1Dto> search(@PathVariable Long id) {
        ScheduleLv1Dto data = service.search(id);
        return ResponseEntity.ok(data);
    }
}
