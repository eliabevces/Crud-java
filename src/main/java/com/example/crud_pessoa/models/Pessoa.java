package com.example.crud_pessoa.models;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.Collections;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private LocalDate data_nascimento;

    @OneToMany
    public List<Endereco> enderecos;

    public Pessoa() {

    }

    public Pessoa(String nome, LocalDate data_nascimento) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.enderecos = Collections.emptyList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Endereco getPrincipalEndereco() {

        for (Endereco endereco : this.enderecos) {
            if (endereco.isPrincipal()) {
                return endereco;
            }
        }
        return null;
    }

    public void setEnderecos(List<Endereco> enderecos) {

        if (enderecos.isEmpty()){
            return;
        }

        boolean hasPrincipal = false;

        for (Endereco endereco : enderecos) {
            if (endereco.isPrincipal()) {
                if (hasPrincipal){                      //Apenas 1 principal
                    endereco.setPrincipal(false);
                }else {
                    hasPrincipal = true;
                }
            }
        }

        if (! hasPrincipal){
            enderecos.get(0).setPrincipal(true);        // Caso não tenha principal o primeiro vira o principal
        }
        this.enderecos = enderecos;
    }

    public void addEndereco(Endereco endereco) {
        if (endereco.isPrincipal()) {
            for (Endereco end : this.enderecos) {
                end.setPrincipal(false);
            }
        }
        if (this.enderecos.isEmpty()){
            endereco.setPrincipal(true);
        }
        enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco) {
        enderecos.remove(endereco);
    }

}
