package com.hotel.src.model;

public class Customer {
    private final long id;
    private String name;
    private static long customerCount = 0;

    // Constructor
    public Customer(String name) {
        this.id = ++customerCount;
        this.name = name;
    }

    // Getters
    public long getId() {return id;}
    public String getName() {return name;}

    // Setters
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return "[Customer]: (" + id + ") | Name: " + name;
    }
}
