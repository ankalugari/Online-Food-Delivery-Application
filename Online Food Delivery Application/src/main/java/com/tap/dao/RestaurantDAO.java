package com.tap.dao;

import com.tap.model.Restaurant;
import java.util.List;

public interface RestaurantDAO {

    // Create a new restaurant
    void createRestaurant(Restaurant restaurant);

    // Get a restaurant by ID
    Restaurant getRestaurantById(int restaurantId);

    // Get all restaurants
    List<Restaurant> getAllRestaurants();

    // Update restaurant details
    void updateRestaurant(Restaurant restaurant);

    // Delete a restaurant
    void deleteRestaurant(int restaurantId);
    List<Restaurant> searchRestaurant(String keyword);

}