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

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private Date data_nascimento;

    @ManyToMany(mappedBy="pessoas", cascade = CascadeType.ALL)
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
