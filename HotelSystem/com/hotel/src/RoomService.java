package com.hotel.src.service;

import com.hotel.src.model.Category;
import com.hotel.src.model.Room;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class RoomService {
    // HashMap to store rooms by their ID for fast lookup
    private final HashMap<Long, Room> rooms;

    public RoomService() {
        this.rooms = new HashMap<>();
    }

    // Add a new room
    public Room addRoom(Category category, double price) {
        Room room = new Room(category, price);
        rooms.put(room.getId(), room);
        return room;
    }

    // Get room by ID (O(1) lookup using HashMap)
    public Room getRoomById(long id) {
        return rooms.get(id);
    }

    // Get all rooms
    public Collection<Room> getAllRooms() {
        return rooms.values();
    }

    // Get available rooms
    public ArrayList<Room> getAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // Get rooms by category
    public ArrayList<Room> getRoomsByCategory(Category category) {
        ArrayList<Room> categoryRooms = new ArrayList<>();
        for (Room room : rooms.values()) {
            if (room.getCategory() == category) {
                categoryRooms.add(room);
            }
        }
        return categoryRooms;
    }

    // Update room availability
    public boolean updateRoomAvailability(long roomId, boolean available) {
        Room room = rooms.get(roomId);
        if (room != null) {
            room.setAvailability(available);
            return true;
        }
        return false;
    }

    // Get room price
    public Double getRoomPrice(long roomId) {
        Room room = rooms.get(roomId);
        return room != null ? room.getPrice() : null;
    }

    // Check if room exists
    public boolean roomExists(long roomId) {
        return rooms.containsKey(roomId);
    }
}