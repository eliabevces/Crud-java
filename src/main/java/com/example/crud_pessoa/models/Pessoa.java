package com.example.crud_pessoa.models;

import java.util.Date;

public class Pessoa {

    private int id;

    private String name;

    private Date born_in;

    private Endereco endereco;

    public Pessoa(int id, String name, Date born_in, Endereco endereco) {
        this.id = id;
        this.name = name;
        this.born_in = born_in;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn_in() {
        return born_in;
    }

    public void setBorn_in(Date born_in) {
        this.born_in = born_in;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
