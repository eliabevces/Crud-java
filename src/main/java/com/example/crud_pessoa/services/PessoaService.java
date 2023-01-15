package com.example.crud_pessoa.services;

import com.example.crud_pessoa.models.Endereco;
import com.example.crud_pessoa.models.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    List<Pessoa> getPessoas();
    Optional<Pessoa> getPessoaById(Long pessoaId);
    Pessoa createOrUpdatePessoa(Pessoa pessoa);
    Pessoa addEnderecoToPessoa(Long pessoaId, Endereco endereco);
    void deletePessoa(Long pessoaId);

}
