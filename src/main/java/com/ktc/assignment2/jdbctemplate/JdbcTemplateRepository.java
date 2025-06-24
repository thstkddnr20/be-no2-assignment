package com.ktc.assignment2.jdbctemplate;

import com.ktc.assignment2.lv1.dto.ScheduleCreate;
import com.ktc.assignment2.lv1.dto.ScheduleLv1Dto;
import com.ktc.assignment2.lv2.dto.ScheduleUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public Long save(ScheduleCreate dto) {
        //insert query
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("lv1schedule").usingGeneratedKeyColumns("id");

        Map<String, Object> params = new HashMap<>();
        params.put("username", dto.getUsername());
        params.put("password", dto.getPassword());
        params.put("title", dto.getTitle());
        params.put("content", dto.getContent());
        params.put("createdAt", Timestamp.valueOf(LocalDateTime.now()));
        params.put("modifiedAt", null);

        BigInteger key = (BigInteger) jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(params));
        return key.longValue();
    }

    //    public void save(ScheduleCreate dto) {
//        String sql = "insert into lv1schedule(username, password, title, content, createdAt, modifiedAt) values(?, ?, ?, ?, ?, ?)";
//
//        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, dto.getUsername());
//            pstmt.setString(2, dto.getPassword());
//            pstmt.setString(3, dto.getTitle());
//            pstmt.setString(4, dto.getContent());
//            pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
//            pstmt.setTimestamp(6, null);
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    public List<ScheduleLv1Dto> findAll(LocalDate start, LocalDate end, String username) {
        //단건 queryForObject(), 여러개 query()
        String sql = "select * from lv1schedule where date_format(modifiedAt, '%Y-%m-%d') between ? and ? and username=? order by modifiedAt desc";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ScheduleLv1Dto(
                rs.getString("username"),
                rs.getString("title"),
                rs.getString("content")),
                start,
                end,
                username
        );
    }


    //    public List<ScheduleLv1Dto> findAll(LocalDate start, LocalDate end, String username) {
//        String sql = "select * from lv1schedule where date_format(modifiedAt, '%Y-%m-%d') between ? and ? and username=? order by modifiedAt desc";
//
//        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setDate(1, Date.valueOf(start));
//            pstmt.setDate(2, Date.valueOf(end));
//            pstmt.setString(3, username);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                List<ScheduleLv1Dto> list = new ArrayList<>();
//                while (rs.next()) {
//                    list.add(new ScheduleLv1Dto(rs.getString(2), rs.getString(4), rs.getString(5)));
//                }
//                return list;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public void update(ScheduleUpdate dto) {
        String sql = "update lv1schedule set username=?, content=?, modifiedAt=? where id=?";
        jdbcTemplate.update(sql, dto.getUsername(), dto.getContent(), Timestamp.valueOf(LocalDateTime.now()), dto.getId());
    }


//    public void update(ScheduleUpdate dto) {
//        String sql = "update lv1schedule set username=?, content=?, modifiedAt=? where id=?";
//
//        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, dto.getUsername());
//            pstmt.setString(2, dto.getContent());
//            pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//            pstmt.setLong(4, dto.getId());
//
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void deleteById(Long id) {
        String sql = "delete from lv1schedule where id=?";
        jdbcTemplate.update(sql, id);
    }

//    public void deleteById(Long id) {
//        String sql = "delete from lv1schedule where id=?";
//
//        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
//            pstmt.setLong(1, id);
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
