package com.hotel.src.model;

public class Payment {
    // final fields: amount of payment must not change be changed.
    private final long id;
    private final double amount;
    private final boolean status;
    private static long paymentCount = 0;

    // Constructor
    public Payment(double amount) {
        this.id = ++paymentCount;
        this.amount = amount;
        this.status = true;
    }

    // Getters
    public long getId() {return id;}
    public double getAmount() {return amount;}
    public boolean isSuccessfull() {return status;}
}