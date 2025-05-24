package com.ktc.assignment2.lv4;

import com.ktc.assignment2.lv4.dto.ScheduleLv4Dto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ktc.assignment2.common.DBUtils.getConnection;

@Repository
public class RepositoryLv4 {

    public List<ScheduleLv4Dto> findAllPaging(int pageNum, int pageSize) {

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement("select * from lv3schedule as s join lv3user u on s.user_id = u.id limit ?, ?")) {
            pstmt.setInt(1, pageNum - 1); //paging은 0부터
            pstmt.setInt(2, pageSize);

            try (ResultSet rs = pstmt.executeQuery()) {
                List<ScheduleLv4Dto> list = new ArrayList<>();
                while (rs.next()) {
                    list.add(new ScheduleLv4Dto(rs.getString(8), rs.getString(3), rs.getString(4)));
                }
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
