package com.dio.sistemaBancariodio.domain;

import com.dio.sistemaBancariodio.enums.TipoCliente;
import lombok.Data;

import java.util.*;

@Data
public class User {

    private String name;
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCliente;
    private String password;
    private List<Address> addresses = new ArrayList<>();
    private Set<String> phone = new HashSet<>();


    public User() {
    }

    public User(String name, String email, String cpfOuCnpj, TipoCliente tipoCliente, String password) {
        this.name = name;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = (tipoCliente == null) ? null : tipoCliente.getCod();
        this.password = password;
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(tipoCliente);
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
    }
}
