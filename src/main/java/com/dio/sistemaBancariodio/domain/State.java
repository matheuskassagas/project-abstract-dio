package com.dio.sistemaBancariodio.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class State {

    private String nome;
    private List<City> cityList = new ArrayList<>();

    public State(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nome);
        return sb.toString();
    }
}
