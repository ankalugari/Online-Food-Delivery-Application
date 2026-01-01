package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tap.dao.UserDao;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDaoImpl implements UserDao {

    // Register user
    @Override
    public boolean registerUser(User user) {

        String sql = "INSERT INTO users(name, email, password, phone) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Login user
    @Override
    public User loginUser(String email, String password) {

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        User user = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Get user by ID
    @Override
    public User getUserById(int id) {

        String sql = "SELECT * FROM users WHERE id = ?";
        User user = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phone")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}