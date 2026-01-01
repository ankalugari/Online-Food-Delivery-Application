package com.tap.daoImpl;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;
import com.tap.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {

    @Override
    public List<Menu> getMenuByRestaurantId(int restaurantId) {

        List<Menu> list = new ArrayList<>();
        String sql = "SELECT * FROM menu WHERE restaurant_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Menu m = new Menu();

                m.setId(rs.getInt("id"));
                m.setRestaurantId(rs.getInt("restaurant_id"));
                m.setItemName(rs.getString("item_name"));
                m.setImageUrl(rs.getString("image_url"));
                m.setRating(rs.getDouble("rating"));
                m.setDescription(rs.getString("description"));
                m.setPrice(rs.getDouble("price"));

                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Menu getMenuById(int id) {

        Menu m = null;
        String sql = "SELECT * FROM menu WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Menu(
                        rs.getInt("id"),
                        rs.getInt("restaurant_id"),
                        rs.getString("item_name"),
                        rs.getString("image_url"),
                        rs.getDouble("rating"),
                        rs.getString("description"),
                        rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return m;
    }
}