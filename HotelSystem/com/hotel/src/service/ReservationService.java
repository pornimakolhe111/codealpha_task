package com.hotel.src.service;

import com.hotel.src.model.Category;
import com.hotel.src.model.Customer;
import com.hotel.src.model.Payment;
import com.hotel.src.model.Reservation;
import com.hotel.src.model.Room;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ReservationService {
    // HashMap to store reservations by their ID
    private final HashMap<Long, Reservation> reservations;

    public ReservationService() {
        this.reservations = new HashMap<>();
    }

    // Create a new reservation
    public Reservation createReservation(Customer customer, Room room, Date startDate, Date endDate) {
        Reservation reservation = new Reservation(customer, room, startDate, endDate);
        // make payment...
        double amount = calculateAmount(room, startDate, endDate);
        System.out.println("\nTotal amount to pay: " + amount);
        System.out.println("Enter to make payment...");
        new Scanner(System.in).nextLine();
        Payment payment = PaymentService.makePayment(amount);

        if(!payment.isSuccessfull()) {
            System.out.println("Payment failed.!");
            return null;
        }

        
        reservations.put(reservation.getId(), reservation);
        // Mark room as unavailable
        room.setAvailability(false);
        return reservation;
    }

    // Calculate amount to be paid
    public double calculateAmount(Room room, Date startDate, Date endDate) {
        double amount = room.getPrice();
        double perDayAmount = 0.0;

        // calculate amount by Category
        switch(room.getCategory()) {
            case Category.STANDARD -> perDayAmount = 1000;
            case Category.DELUX -> perDayAmount = 500;
            case Category.SUIT -> perDayAmount = 200;
        }

        // calculate amount by days
        long difference = Math.abs(endDate.getTime() - startDate.getTime());
        difference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
        amount += (difference * perDayAmount);

        return amount;
    }

    // Get reservation by ID
    public Reservation getReservationById(long id) {
        return reservations.get(id);
    }

    // Get all reservations
    public Collection<Reservation> getAllReservations() {
        return reservations.values();
    }

    // Get reservations by customer
    public ArrayList<Reservation> getReservationsByCustomerName(String customerName) {
        ArrayList<Reservation> customerReservations = new ArrayList<>();
        for (Reservation reservation : reservations.values()) {
            if (customerName.equalsIgnoreCase(reservation.getCustomer().getName())) {
                customerReservations.add(reservation);
            }
        }
        return customerReservations;
    }

    // Cancel reservation
    public boolean cancelReservation(long reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation != null) {
            // Mark room as available again
            reservation.getRoom().setAvailability(true);
            System.out.println("\nCanceling reservation: " + reservation + " and making room available.");
            // reservations.remove(reservationId); // will keep reservation record in system.
            return true;
        }
        return false;
    }

    // Check if room is available for given dates
    public boolean checkRoomAvailability(Room room, Date startDate, Date endDate) {
        if (!room.isAvailable()) {
            return false;
        }
        // Check if room has any overlapping reservations
        for (Reservation reservation : reservations.values()) {
            if (reservation.getRoom().getId() == room.getId()) {
                // Check for date overlap
                if (!(endDate.before(reservation.getStartDate()) || 
                      startDate.after(reservation.getEndDate()))) {
                    return false;
                }
            }
        }
        return true;
    }

    // Check if reservation exists
    public boolean reservationExists(long reservationId) {
        return reservations.containsKey(reservationId);
    }
}
