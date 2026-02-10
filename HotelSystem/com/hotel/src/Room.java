package com.hotel.src.model;

public class Room {
    private final long id;
    private Category category;
    private double price;
    private boolean available;
    private static long roomCount = 0;

    // Constructor
    public Room(Category category, double price) {
        this.id = ++roomCount;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    // Copy Constructor
    public Room(Room room) {
        this.id = ++roomCount;
        this.category = room.category;
        this.price = room.price;
        this.available = true;
    }

    // Getters
    public long getId() {return id;}
    public Category getCategory() {return category;}
    public double getPrice() {return price;}
    public boolean isAvailable() {return available;}

    // Setters
    public void setCategory(Category category) {this.category = category;}
    public void setPrice(double price) {this.price = price;}
    public void setAvailability(boolean status) {this.available = status;}

    // toString()
    @Override
    public String toString() {
        return "[ROOM]: (" + id + ") | Category: " + category + " | price: " + price + " | '" + available + "'.";
    }
}