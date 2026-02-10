package com.hotel.src.main;
import com.hotel.src.model.Category;
import com.hotel.src.model.Customer;
import com.hotel.src.model.Reservation;
import com.hotel.src.service.PaymentService;
import com.hotel.src.service.ReservationService;
import com.hotel.src.service.RoomService;
import java.util.Collection;
import java.util.Date;

public class HotelApplication {
    public static void main(String [] args) {
        RoomService roomService = new RoomService();
        ReservationService reservationService = new ReservationService();
        

        // Room management
        System.out.println("\nAdding 3 STANDARD rooms...");
        roomService.addRoom(Category.STANDARD, 2000);
        roomService.addRoom(Category.STANDARD, 2000);
        roomService.addRoom(Category.STANDARD, 2000);

        System.out.println("\nAdding 3 DELUX rooms...");
        roomService.addRoom(Category.DELUX, 1000);
        roomService.addRoom(Category.DELUX, 1000);
        roomService.addRoom(Category.DELUX, 1000);

        System.out.println("\nAdding 3 SUITABLE rooms...");
        roomService.addRoom(Category.SUIT, 500);
        roomService.addRoom(Category.SUIT, 500);
        roomService.addRoom(Category.SUIT, 500);

        // Reservation management
        System.out.println("\nReserving 3 rooms...");
        reservationService.createReservation(new Customer("Saksham"), roomService.getRoomById(1), new Date(2026, 01, 10), new Date(2026, 01, 15));
        reservationService.createReservation(new Customer("Pushkar"), roomService.getRoomById(4), new Date(2026, 01, 10), new Date(2026, 01, 14));
        reservationService.createReservation(new Customer("Rupesh"), roomService.getRoomById(7), new Date(2026, 01, 10), new Date(2026, 01, 13));

        // Displaying reservations
        System.out.println("\nDisplaying all reservations:");
        Collection<Reservation> reservations = reservationService.getAllReservations();
        for(Reservation r : reservations) {
            System.out.println(r);
        }

        // total balance of client
        System.out.println("\nTotal balance: " + PaymentService.getTotalBalance());

        if(!reservationService.cancelReservation(3)) {
            System.out.println("Reservation not found with id '3'.");
        }

        System.out.println(reservationService.checkRoomAvailability(roomService.getRoomById(1), new Date(2026, 01, 16), new Date(2026, 01, 18)));
    }

}
