package com.dio.sistemaBancariodio.domain;


import com.dio.sistemaBancariodio.gateway.GatewayOperacoes;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public abstract class Account implements GatewayOperacoes {

    private static int SEQUENCIAL = 1;

    private Integer bankAgencia;
    private Integer numberAccount;
    private double balance;
    private User user;

    public Account(User user){
        this.bankAgencia = new Bank().getAgencia();
        this.numberAccount = SEQUENCIAL++;
        this.user = user;
    }

    @Override
    public boolean withdraw(double value) {
        if(this.balance == 0 || this.balance < value ) {
            System.out.println(getUser().getName() + ": Seu saldo é insuficiente.\n");
        }else{
            this.balance = this.balance - value;
            return true;
        }
        return false;


    }

    @Override
    public void deposit(double value) {
        this.balance += value;
    }

    @Override
    public void transfer(double value, GatewayOperacoes accountDestiny) {
        double tax = 10.5;
        if(withdraw(value) == true){
            withdraw(value);
            accountDestiny.deposit(value);
            this.balance = this.balance - tax;
        }

    }

    @Override
    public void printExtract() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(String.format("Titular: %s", this.user.getName()));
        System.out.println(String.format("Agencia: %d", this.getBankAgencia()));
        System.out.println(String.format("Conta: %d", this.getNumberAccount()));
        System.out.println(String.format("Saldo: %.2f", this.getBalance()));
        System.out.println(String.format(sdf.format(new Date(System.currentTimeMillis())))+ "\n");
    }

    @Override
    public String printUser(){
        System.out.println(String.format("Titular: %s", this.user.getName()));
        System.out.println(String.format("Conta: %d", this.getNumberAccount()));
        System.out.println(String.format("Saldo: %.2f", this.getBalance()));
        System.out.println(String.format("TIPO CLIENTE: %s", this.user.getTipoCliente()));
        System.out.println(String.format("Numero identificacao: %s", this.user.getCpfOuCnpj()));
        System.out.println(String.format("Contato: %s", this.user.getPhone()));
        System.out.println(String.format("Endereço: %s", this.user.getAddresses()));
        return null;
    }
}


