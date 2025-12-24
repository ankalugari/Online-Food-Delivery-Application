package com.tap.dao;

import com.tap.dao.*;
import com.tap.model.Menu;

import java.util.List;

public interface MenuDAO {
    void createMenu(Menu menu);               // Add a new menu item
    Menu getMenuById(int menuId);             // Fetch a menu item by ID
    List<Menu> getAllMenus();                 // Fetch all menu items
    void updateMenu(Menu menu);               // Update menu item information
    void deleteMenu(int menuId);              // Delete a menu item by ID
	List<Menu> getMenusByRestaurantId(int restaurantId);
	List<Menu> searchMenu(String keyword);

}
