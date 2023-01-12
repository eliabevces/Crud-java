package com.example.crud_pessoa.repositories;

import com.example.crud_pessoa.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    List<Endereco> findEnderecosByPessoasId(Long pessoaId);
}
