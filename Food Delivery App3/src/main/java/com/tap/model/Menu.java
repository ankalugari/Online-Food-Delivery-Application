package com.tap.model;

public class Menu {

    private int id;
    private int restaurantId;
    private String itemName;
    private String imageUrl;
    private double rating;
    private String description;
    private double price;

    // Constructors
    public Menu() {}

    public Menu(int id, int restaurantId, String itemName,
                String imageUrl, double rating,
                String description, double price) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.description = description;
        this.price = price;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	@Override
	public String toString() {
		return "Menu [id=" + id + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", imageUrl=" + imageUrl
				+ ", rating=" + rating + ", description=" + description + ", price=" + price + "]";
	}
    
}