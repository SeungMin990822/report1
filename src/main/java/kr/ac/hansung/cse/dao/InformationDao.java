package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InformationDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement = "SELECT COUNT(*) FROM informations";  // Table name changed to 'information'
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public Information getInformation(String name) {
        String sqlStatement = "select * from informations where name=?";  // Table name changed
        return jdbcTemplate.queryForObject(sqlStatement, new Object[]{name},
                new RowMapper<Information>() {
                    @Override
                    public Information mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Information info = new Information();

                        info.setYear(rs.getInt("year"));
                        info.setSemester(rs.getInt("semester"));
                        info.setTitle(rs.getString("title"));
                        info.setStatus(rs.getString("status"));
                        info.setName(rs.getString("name"));
                        info.setCredit(rs.getInt("credit"));

                        return info;
                    }
                });
    }

    public List<Information> getInformations() {
        String sqlStatement = "select * from informations";  // Table name changed
        return jdbcTemplate.query(sqlStatement, new RowMapper<Information>() {
            @Override
            public Information mapRow(ResultSet rs, int rowNum) throws SQLException {
                Information info = new Information();

                info.setYear(rs.getInt("year"));
                info.setSemester(rs.getInt("semester"));
                info.setTitle(rs.getString("title"));
                info.setStatus(rs.getString("status"));
                info.setName(rs.getString("name"));
                info.setCredit(rs.getInt("credit"));

                return info;
            }
        });
    }

    public boolean insert(Information info) {
        String sqlStatement = "insert into informations (year, semester, title, status, name, credit) values (?, ?, ?, ?, ?, ?)";
        return (jdbcTemplate.update(sqlStatement, new Object[]{
                info.getYear(),
                info.getSemester(),
                info.getTitle(),
                info.getStatus(),
                info.getName(),
                info.getCredit()
        }) == 1);
    }

    public boolean update(Information info) {
        String sqlStatement = "update informations set year=?, semester=?, title=?, status=?, name=?, credit=? where name=?";
        return (jdbcTemplate.update(sqlStatement, new Object[]{
                info.getYear(),
                info.getSemester(),
                info.getTitle(),
                info.getStatus(),
                info.getName(),
                info.getCredit(),
                info.getName()
        }) == 1);
    }

    public boolean delete(String name) {
        String sqlStatement = "delete from informations where name=?";
        return (jdbcTemplate.update(sqlStatement, new Object[]{name}) == 1);
    }

    public List<Information> getCreditSummary() {
        String sqlStatement = "SELECT year, semester, SUM(credit) AS totalCredit FROM informations GROUP BY year, semester WITH ROLLUP";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Information>() {
            @Override
            public Information mapRow(ResultSet rs, int rowNum) throws SQLException {
                Information info = new Information();

                // WITH ROLLUP generates a row with NULL in year and semester for the total
                // Handle this case to set a specific value if required
                info.setYear(rs.getObject("year") == null ? -1 : rs.getInt("year"));  // -1 or any value to indicate total
                info.setSemester(rs.getObject("semester") == null ? -1 : rs.getInt("semester")); // -1 or any value to indicate total
                info.setCredit(rs.getInt("totalCredit"));  // Use the alias totalCredit

                // Set other fields as required or keep them null/empty
                info.setTitle(""); // Example
                info.setStatus(""); // Example
                info.setName(""); // Example

                return info;
            }
        });
    }

}