package com.university.dao;

import com.university.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, new RowMapper<Course>() {
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course c = new Course();
                c.setCourseId(rs.getInt("course_id"));
                c.setName(rs.getString("name"));
                c.setInstructor(rs.getString("instructor"));
                c.setCredits(rs.getInt("credits"));
                return c;
            }
        });
    }

    public boolean isAlreadyRegistered(int studentId, int courseId) {
        String sql = "SELECT COUNT(*) FROM registrations WHERE student_id=? AND course_id=?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, studentId, courseId);
        return count > 0;
    }

    public void registerCourse(int studentId, int courseId) {
        String sql = "INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, CURDATE())";
        jdbcTemplate.update(sql, studentId, courseId);
    }
}