package com.dio.sistemaBancariodio.domain;


public class SavingsAccount extends Account{

    public SavingsAccount(User user) {
        super(user);
    }

    @Override
    public void printExtract() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.printExtract();
    }
}
