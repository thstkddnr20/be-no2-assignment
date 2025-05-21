package com.ktc.assignment2.lv2;

import com.ktc.assignment2.lv2.dto.ScheduleDelete;
import com.ktc.assignment2.lv2.dto.ScheduleUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lv2")
public class ControllerLv2 {

    private final ServiceLv2 service;

    @PatchMapping("/schedule")
    public ResponseEntity<?> update(@RequestBody ScheduleUpdate updateDto) {
        service.update(updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestBody ScheduleDelete deleteDto) {
        service.delete(id, deleteDto);
        return ResponseEntity.ok().build();
    }
}
