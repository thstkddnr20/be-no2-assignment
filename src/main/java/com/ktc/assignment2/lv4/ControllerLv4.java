package com.ktc.assignment2.lv4;

import com.ktc.assignment2.lv4.dto.ScheduleLv4Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lv4")
public class ControllerLv4 {

    private final ServiceLv4 service;

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleLv4Dto>> searchAll(
            @RequestParam int pageNum,
            @RequestParam int pageSize
    ) {
        List<ScheduleLv4Dto> list = service.searchAll(pageNum, pageSize);
        return ResponseEntity.ok(list);
    }


}
