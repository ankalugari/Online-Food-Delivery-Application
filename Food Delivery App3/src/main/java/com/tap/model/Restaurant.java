package com.tap.model;

public class Restaurant {

    private int id;
    private String name;
    private String imageUrl;
    private double rating;
    private String address;
    private String description;
    private String eta;

    // Constructors
    public Restaurant() {}

    public Restaurant(int id, String name, String imageUrl, double rating,
                      String address, String description, String eta) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.address = address;
        this.description = description;
        this.eta = eta;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEta() { return eta; }
    public void setEta(String eta) { this.eta = eta; }
    
    @Override
    public String toString() {
        return "Restaurant {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                ", eta='" + eta + '\'' +
                '}';
    }
}