package com.dio.sistemaBancariodio.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {

    private static final int AGENCIA_PADRAO = 1;
    private static final String NOME = "Dio Bank";

    private Integer agencia = Bank.AGENCIA_PADRAO;
    private String bankName;
    private List<Account> accounts = new ArrayList<>();

    public Bank(List<Account> accounts) {
        this.agencia = Bank.AGENCIA_PADRAO;
        this.bankName = Bank.NOME;
        this.accounts = accounts;
    }

    public Bank() {
    }

    public void printAcconts(){
        for (Account account : accounts){
            System.out.println(account.printUser());
        }
    }
}
