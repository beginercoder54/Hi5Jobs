/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Hi5Jobs.repository;

import com.Hi5Jobs.models.FavoriteJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FavoriteJobRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FavoriteJob mapRow(ResultSet rs, int rowNum) throws SQLException {
        FavoriteJob favorite = new FavoriteJob();
        favorite.setFavoriteJobID(rs.getInt("FavoriteID"));
        favorite.setUserID(rs.getInt("UserID"));
        favorite.setJobID(rs.getInt("JobID"));
        return favorite;
    }

    public List<FavoriteJob> getByUserID(int userID) {
        String sql = "SELECT * FROM FavoriteJob WHERE UserID = ?";
        return jdbcTemplate.query(sql, this::mapRow, userID);
    }

    public int addFavorite(FavoriteJob favoriteJob) {
        String sql = "INSERT INTO FavoriteJob (UserID, JobID) VALUES (?, ?)";
        return jdbcTemplate.update(sql, favoriteJob.getUserID(), favoriteJob.getJobID());
    }

    public boolean isFavoriteExisted(int userId, int jobId) {
        String sql = "SELECT COUNT(*) FROM FavoriteJob WHERE UserID = ? AND JobID = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, userId, jobId);
        return count != null && count > 0;
    }

}
