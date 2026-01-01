package com.tap.dao;

import java.util.List;
import com.tap.model.Menu;

public interface MenuDao {

    List<Menu> getMenuByRestaurantId(int restaurantId);

    Menu getMenuById(int id);
}