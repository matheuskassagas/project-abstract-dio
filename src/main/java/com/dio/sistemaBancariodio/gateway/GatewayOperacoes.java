package com.dio.sistemaBancariodio.gateway;


public interface GatewayOperacoes {

    boolean withdraw (double value);

    void deposit (double value);

    void transfer (double value, GatewayOperacoes accountDestiny);

    void printExtract();

    String printUser();
}
