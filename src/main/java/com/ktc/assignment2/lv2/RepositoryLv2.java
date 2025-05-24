package com.ktc.assignment2.lv2;

import com.ktc.assignment2.lv2.dto.ScheduleUpdate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;

import static com.ktc.assignment2.common.DBUtils.getConnection;

@Repository
public class RepositoryLv2 {

    public void update(ScheduleUpdate dto) {
        String sql = "update lv1schedule set username=?, content=?, modifiedAt=? where id=?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dto.getUsername());
            pstmt.setString(2, dto.getContent());
            pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setLong(4, dto.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String findPasswordById(Long id) {
        String sql = "select password from lv1schedule where id=?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                String password = null;
                while (rs.next()) {
                    password = rs.getString(1);
                }
                return password;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Long id) {
        String sql = "delete from lv1schedule where id=?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
