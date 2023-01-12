package com.example.crud_pessoa.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private Date data_nascimento;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "enderecos_pessoas",
            joinColumns = { @JoinColumn(name = "pessoa_id") },
            inverseJoinColumns = { @JoinColumn(name = "endereco_id") })
    private List<Endereco> enderecos;

    public Pessoa() {

    }

    public Pessoa(Long id, String nome, Date data_nascimento, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.enderecos = enderecos;
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date born_in) {
        this.data_nascimento = born_in;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
