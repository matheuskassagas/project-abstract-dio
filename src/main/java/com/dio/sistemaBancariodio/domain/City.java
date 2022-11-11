package com.dio.sistemaBancariodio.domain;

import lombok.Data;

@Data
public class City {
    private String name;
    private State state;

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name).append('\n');
        sb.append(state);
        return sb.toString();
    }
}
