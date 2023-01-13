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

    @GetMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> getAllPessoaById(@PathVariable(value = "pessoaId") Long pessoaId) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if(pessoa.isPresent()){
            return new ResponseEntity<>(pessoa.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{pessoaId}/principalendereco")
    public ResponseEntity<Endereco> getPrincipalEndereco(@PathVariable(value = "pessoaId") Long pessoaId) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if(pessoa.isPresent()){
            return new ResponseEntity<>(pessoa.get().getPrincipalEndereco(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{pessoaId}/enderecos")
    public ResponseEntity<List<Endereco>> getAllEnderecosByPessoaId(@PathVariable(value = "pessoaId") Long pessoaId) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if(pessoa.isPresent()){
            return new ResponseEntity<>(pessoa.get().getEnderecos(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{pessoaId}/enderecos")
    public ResponseEntity<Pessoa> addEnderecoToPessoa(@RequestBody Endereco endereco, @PathVariable(value = "pessoaId") Long pessoaId) {
        try {
            Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
            if(pessoa.isPresent()){
                pessoa.get().addEndereco(endereco);
                enderecoRepository.save(endereco);
                return new ResponseEntity<>(pessoaRepository.save(pessoa.get()), HttpStatus.ACCEPTED);

            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
