package com.dio.sistemaBancariodio.domain;

import java.util.Calendar;
import java.util.Date;

public class CheckAccount extends Account {

    public CheckAccount(User user) {
        super(user);
    }

    public Calendar currentDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((new Date(System.currentTimeMillis())));
        return calendar;
    }

    public void bankFee(){
        double tax = -49.9;
        if (currentDate().get(Calendar.DAY_OF_MONTH) == 20 ){
            super.setBalance(super.getBalance() + tax);
        }
    }

    @Override
    public void printExtract() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.printExtract();
    }

}
