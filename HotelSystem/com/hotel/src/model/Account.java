package com.hotel.src.model;

public class Account {
    private double balance;

    // Constructor
    public Account() {
        balance = 0;
    }

    //Getters
    public double getBalance() {return balance;}

    public void addAmount(double amount) {this.balance += amount;}

}
