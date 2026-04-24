package com.university.dao;

import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM students WHERE email=? AND password=?";
        List<Student> students = jdbcTemplate.query(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPassword(rs.getString("password"));
                return s;
            }
        }, email, password);
        return students.isEmpty() ? null : students.get(0);
    }
}