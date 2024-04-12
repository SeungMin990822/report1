package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Enroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EnrollDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement = "SELECT COUNT(*) FROM enrolls";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public Enroll getEnroll(String name) {
        String sqlStatement = "select * from enrolls where name=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[]{name},
                new RowMapper<Enroll>() {
                    @Override
                    public Enroll mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Enroll enroll = new Enroll();

                        enroll.setYear(rs.getInt("year"));
                        enroll.setSemester(rs.getString("semester"));
                        enroll.setTitle(rs.getString("title"));
                        enroll.setStatus(rs.getString("status"));
                        enroll.setName(rs.getString("name"));
                        enroll.setCredit(rs.getInt("credit"));

                        return enroll;
                    }
                });
    }

    public List<Enroll> getEnrolls() {
        String sqlStatement = "select * from enrolls";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Enroll>() {
            @Override
            public Enroll mapRow(ResultSet rs, int rowNum) throws SQLException {
                Enroll enroll = new Enroll();

                enroll.setYear(rs.getInt("year"));
                enroll.setSemester(rs.getString("semester"));
                enroll.setTitle(rs.getString("title"));
                enroll.setStatus(rs.getString("status"));
                enroll.setName(rs.getString("name"));
                enroll.setCredit(rs.getInt("credit"));

                return enroll;
            }
        });
    }

    public boolean insert(Enroll enroll) {
        String sqlStatement = "insert into enrolls (year, semester, title, status, name, credit) values (?, ?, ?, ?, ?, ?)";
        return (jdbcTemplate.update(sqlStatement, new Object[]{
                enroll.getYear(),
                enroll.getSemester(),
                enroll.getTitle(),
                enroll.getStatus(),
                enroll.getName(),
                enroll.getCredit()
        }) == 1);
    }

    public boolean update(Enroll enroll) {
        String sqlStatement = "update enrolls set year=?, semester=?, title=?, status=?, name=?, credit=? where name=?";
        return (jdbcTemplate.update(sqlStatement, new Object[]{
                enroll.getYear(),
                enroll.getSemester(),
                enroll.getTitle(),
                enroll.getStatus(),
                enroll.getName(),
                enroll.getCredit(),
                enroll.getName()
        }) == 1);
    }

    public boolean delete(String name) {
        String sqlStatement = "delete from enrolls where name=?";
        return (jdbcTemplate.update(sqlStatement, new Object[]{name}) == 1);
    }

}
