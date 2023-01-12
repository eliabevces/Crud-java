package com.example.crud_pessoa.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "logradouro")
    private String Logradouro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private int numero;

    @Column(name = "cidade")
    private String cidade;

    @ManyToMany(mappedBy="enderecos", cascade = CascadeType.ALL)
    private List<Pessoa> pessoas;

    public Endereco() {

    }

    public Endereco(Long id, String logradouro, String cep, int numero, String cidade, List<Pessoa> pessoas) {
        this.id = id;
        Logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoas = pessoas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return Logradouro;
    }

    public void setLogradouro(String logradouro) {
        Logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
