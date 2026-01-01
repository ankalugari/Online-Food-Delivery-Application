package com.tap.daoImpl;

import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;
import com.tap.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDaoImpl implements RestaurantDao {

    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> list = new ArrayList<>();
        String sql = "SELECT * FROM restaurant";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Restaurant r = new Restaurant();

                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setImageUrl(rs.getString("image_url"));
                r.setRating(rs.getDouble("rating"));
                r.setAddress(rs.getString("address"));
                r.setDescription(rs.getString("description"));
                r.setEta(rs.getString("eta"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Restaurant getRestaurantById(int id) {

        Restaurant r = null;
        String sql = "SELECT * FROM restaurant WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r = new Restaurant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image_url"),
                        rs.getDouble("rating"),
                        rs.getString("address"),
                        rs.getString("description"),
                        rs.getString("eta")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}