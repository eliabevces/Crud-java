package com.example.crud_pessoa.controllers;

import com.example.crud_pessoa.models.Endereco;
import com.example.crud_pessoa.models.Pessoa;
import com.example.crud_pessoa.repositories.EnderecoRepository;
import com.example.crud_pessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        try {
            List<Pessoa> list = pessoaRepository.findAll();

            if (list.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{pessoaId}/enderecos")
    public ResponseEntity<List<Endereco>> getAllEnderecosByPessoaId(@PathVariable(value = "pessoaId") Long pessoaId) {
        if (!pessoaRepository.existsById(pessoaId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<Endereco> enderecos = enderecoRepository.findEnderecosByPessoasId(pessoaId);
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePessoa(@PathVariable Long id) {
        try {
            Optional<Pessoa> pessoa = pessoaRepository.findById(id);
            pessoa.ifPresent(value -> pessoaRepository.delete(value));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
