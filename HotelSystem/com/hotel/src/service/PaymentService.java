package com.hotel.src.service;

import com.hotel.src.model.Account;
import com.hotel.src.model.Payment;
import java.util.Collection;
import java.util.HashMap;

public class PaymentService {
    private static final HashMap<Long, Payment> payments = new HashMap<>();
    // variable for hotel account.
    // all the payment amount will be added into the account balance for tax purpose.
    private static final Account account = new Account();

    public static Payment makePayment(double amount) {
        Payment payment = new Payment(amount);
        payments.put(payment.getId(), payment);
        account.addAmount(amount);
        return new Payment(amount);
    }

    public static Collection<Payment> getAllPayments() {
        return payments.values();
    }

    public static double getTotalBalance() {
        return account.getBalance();
    }

}
