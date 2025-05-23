package com.ktc.assignment2.lv1;

import com.ktc.assignment2.lv1.dto.ScheduleCreate;
import com.ktc.assignment2.lv1.dto.ScheduleLv1Dto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ktc.assignment2.common.DBUtils.getConnection;

@Repository
public class RepositoryLv1 {

    public void save(ScheduleCreate dto) {
        String sql = "insert into lv1schedule(username, password, title, content, createdAt, modifiedAt) values(?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dto.getUsername());
            pstmt.setString(2, dto.getPassword());
            pstmt.setString(3, dto.getTitle());
            pstmt.setString(4, dto.getContent());
            pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setTimestamp(6, null);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<ScheduleLv1Dto> findAll(LocalDate start, LocalDate end, String username) {
        String sql = "select * from lv1schedule where date_format(modifiedAt, '%Y-%m-%d') between ? and ? and username=? order by modifiedAt desc";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(start));
            pstmt.setDate(2, Date.valueOf(end));
            pstmt.setString(3, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                List<ScheduleLv1Dto> list = new ArrayList<>();
                while (rs.next()) {
                    list.add(new ScheduleLv1Dto(rs.getString(2), rs.getString(4), rs.getString(5)));
                }
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<ScheduleLv1Dto> findById(Long id) {
        String sql = "select * from lv1schedule where id=?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                ScheduleLv1Dto dto = null;

                while (rs.next()) {
                    dto = new ScheduleLv1Dto(rs.getString(2), rs.getString(4), rs.getString(5));
                }

                return Optional.ofNullable(dto);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
