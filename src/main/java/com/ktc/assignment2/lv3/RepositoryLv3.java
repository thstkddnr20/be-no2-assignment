package com.ktc.assignment2.lv3;

import com.ktc.assignment2.lv3.dto.ScheduleCreate;
import com.ktc.assignment2.lv3.dto.ScheduleLv3Dto;
import com.ktc.assignment2.lv3.dto.UserAdd;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.ktc.assignment2.common.DBUtils.getConnection;

@Repository
public class RepositoryLv3 {

    public List<ScheduleLv3Dto> findAll(LocalDate start, LocalDate end, Long userId) {

        String sql = "select * from lv3schedule as s where date_format(modifiedAt, '%Y-%m-%d') between ? and ? and s.user_id=? order by modifiedAt desc";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(start));
            pstmt.setDate(2, Date.valueOf(end));
            pstmt.setLong(3, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<ScheduleLv3Dto> list = new ArrayList<>();
                while (rs.next()) {
                    list.add(new ScheduleLv3Dto(rs.getString(3), rs.getString(4), rs.getTimestamp(5).toLocalDateTime(), rs.getTimestamp(6).toLocalDateTime()));
                }

                return list;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createSchedule(ScheduleCreate createDto) {
        String sql = "insert into lv3schedule(user_id, title, content, createdAt, modifiedAt) values(?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, createDto.getUserId());
            pstmt.setString(2, createDto.getTitle());
            pstmt.setString(3, createDto.getContent());
            pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setTimestamp(5, null);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(UserAdd userAdd) {
        String sql = "insert into lv3user(name, password, email, createdAt, modifiedAt) values(?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userAdd.getName());
            pstmt.setString(2, userAdd.getPassword());
            pstmt.setString(3, userAdd.getEmail());
            pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setTimestamp(5, null);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
