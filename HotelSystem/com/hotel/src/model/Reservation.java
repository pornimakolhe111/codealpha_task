package com.hotel.src.model;

import java.util.Date;

public class Reservation {
    private final long id;
    private Customer customer;
    private Room room;
    private Date startDate;
    private Date endDate;
    private static long reservationCount = 0;

    // Constructor
    public Reservation(Customer customer, Room room, Date starDate, Date enDate) {
        this.id = ++reservationCount;
        this.customer = customer;
        this.room = room;
        this.startDate = starDate;
        this.endDate = enDate;
    }

    // Getters
    public long getId() {return id;}
    public Customer getCustomer() {return customer;}
    public Room getRoom() {return room;}
    public Date getStartDate() {return startDate;}
    public Date getEndDate() {return endDate;}

    // Setters
    public void setCustomer(Customer customer) {this.customer = customer;}
    public void setRoom(Room room) {this.room = room;}
    public void setStartDate(Date starDate) {this.startDate = starDate;}
    public void setEndDate(Date endDate) {this.endDate = endDate;}

    @Override
    public String toString() {
        return "[Reservation]: Room: " + room.getId() + " is alloted to " + customer;
    }
}
