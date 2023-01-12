package com.example.crud_pessoa.repositories;

import com.example.crud_pessoa.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
