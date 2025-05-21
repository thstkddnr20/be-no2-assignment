package com.ktc.assignment2.lv4;

import com.ktc.assignment2.lv4.dto.ScheduleLv4Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLv4 {

    private final RepositoryLv4 repository;

    public List<ScheduleLv4Dto> searchAll(int pageNum, int pageSize) {
        return repository.findAllPaging(pageNum, pageSize);
    }
}
