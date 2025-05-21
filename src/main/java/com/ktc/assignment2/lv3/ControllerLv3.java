package com.ktc.assignment2.lv3;

import com.ktc.assignment2.lv3.dto.ScheduleCreate;
import com.ktc.assignment2.lv3.dto.ScheduleLv3Dto;
import com.ktc.assignment2.lv3.dto.UserAdd;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerLv3 {

    private final ServiceLv3 service;

    //ControllerLv3 부터 Validation 적용

    @PostMapping("/api/lv3/user") //편의를 위해 Controller 분리 안하고 같이 작성
    public ResponseEntity<?> addUser(@RequestBody @Valid UserAdd userAdd) {
        service.addUser(userAdd);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/lv3/schedule")
    public void create(@RequestBody @Valid ScheduleCreate createDto) {
        service.create(createDto);
    }

    @GetMapping("/api/lv3/schedule")
    public ResponseEntity<List<ScheduleLv3Dto>> searchAll(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam Long userId) {
        List<ScheduleLv3Dto> list = service.searchAll(start, end, userId);
        return ResponseEntity.ok(list);
    }
}
