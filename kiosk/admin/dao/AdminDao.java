package com.kobuks.kiosk.admin.dao;

import com.kobuks.kiosk.admin.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public class AdminDao {

        @Autowired
        private JdbcTemplate jdbcTemplate;

    public Admin selectAdminByIdAndPassword(String id, String password) {
        String query = "SELECT * FROM Admin WHERE id = ? AND password = ?";
        RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<>(Admin.class);
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            Admin admin = new Admin();
            admin.setId(rs.getString("id"));
            admin.setPassword(rs.getString("password"));
            return admin;
        }, id, password);
    }

    public List<Admin> selectAllAdmins() {
        String query = "SELECT * FROM Admin";
        RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<Admin>(Admin.class);
        return jdbcTemplate.query(query, rowMapper);
    }



}
