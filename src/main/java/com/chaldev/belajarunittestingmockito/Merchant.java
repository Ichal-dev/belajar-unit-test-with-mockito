package com.chaldev.belajarunittestingmockito;

public class Merchant {


    public String payment(Long payment) {
        return "payment this is call" + payment;
    }

    public String paymentIterable(Iterable iterable){
        return "employee iterable this is call";
    }
}
