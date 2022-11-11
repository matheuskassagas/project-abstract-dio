package com.dio.sistemaBancariodio.domain;

import lombok.Data;

@Data
public class Address {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private User user;
    private City city;

    public Address(String logradouro, String numero, String complemento, String bairro, String cep, User user, City city) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.user = user;
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Logradouro: ").append(logradouro).append('\n');
        sb.append("Numero: ").append(numero).append('\n');
        sb.append("Complemento: ").append(complemento).append('\n');
        sb.append("Bairro: ").append(bairro).append('\n');
        sb.append("Cep: ").append(cep).append('\n');
        sb.append("Cidade: ").append(city).append('\n');
        sb.append("Estado: ").append(city.getState()).append('\n');
        return sb.toString();
    }
}
