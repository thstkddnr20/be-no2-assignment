package com.ktc.assignment2.lv2;

import com.ktc.assignment2.jdbctemplate.JdbcTemplateRepository;
import com.ktc.assignment2.lv2.dto.ScheduleDelete;
import com.ktc.assignment2.lv2.dto.ScheduleUpdate;
import com.ktc.assignment2.lv5.exception.PasswordInvalidException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceLv2 {

    private final RepositoryLv2 repository;
    private final JdbcTemplateRepository jdbcTemplateRepository;

    public void update(ScheduleUpdate updateDto) {
        String password = getPassword(updateDto.getId());
        if (!password.equals(updateDto.getPassword())) {
            throw new PasswordInvalidException();
        }
        repository.update(updateDto);
    }

    public void updateWithJdbcTemplate(ScheduleUpdate updateDto) {
        String password = getPassword(updateDto.getId());
        if (!password.equals(updateDto.getPassword())) {
            throw new PasswordInvalidException();
        }
        jdbcTemplateRepository.update(updateDto);
    }

    public void delete(Long id, ScheduleDelete deleteDto) {
        String password = getPassword(id);
        if (!password.equals(deleteDto.getPassword())) {
            throw new PasswordInvalidException();
        }
        repository.deleteById(id);
    }

    public void deleteWithJdbcTemplate(Long id, ScheduleDelete deleteDto) {
        String password = getPassword(id);
        if (!password.equals(deleteDto.getPassword())) {
            throw new PasswordInvalidException();
        }
        jdbcTemplateRepository.deleteById(id);
    }

    private String getPassword(Long id) {
        return repository.findPasswordById(id);
    }

}
