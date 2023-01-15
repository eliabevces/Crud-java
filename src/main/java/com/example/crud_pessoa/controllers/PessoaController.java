package com.example.crud_pessoa.controllers;

import com.example.crud_pessoa.models.Endereco;
import com.example.crud_pessoa.models.Pessoa;
import com.example.crud_pessoa.services.PessoaService;
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
    PessoaService pessoaService;


    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        try {
            List<Pessoa> list = pessoaService.getPessoas();

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
        try {
            Optional<Pessoa> pessoa = pessoaService.getPessoaById(pessoaId);

            if (pessoa.isPresent()){
                return new ResponseEntity<>(pessoa.get(), HttpStatus.OK);

            }

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{pessoaId}/principalendereco")
    public ResponseEntity<Endereco> getPrincipalEndereco(@PathVariable(value = "pessoaId") Long pessoaId) {
        try {
            Optional<Pessoa> pessoa = pessoaService.getPessoaById(pessoaId);

            if (pessoa.isPresent()){
                return new ResponseEntity<>(pessoa.get().getPrincipalEndereco(), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{pessoaId}/enderecos")
    public ResponseEntity<List<Endereco>> getAllEnderecosByPessoaId(@PathVariable(value = "pessoaId") Long pessoaId) {
        try {
            Optional<Pessoa> pessoa = pessoaService.getPessoaById(pessoaId);

            if (pessoa.isPresent()){
                return new ResponseEntity<>(pessoa.get().getEnderecos(), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Pessoa> createOrUpdatePessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(pessoaService.createOrUpdatePessoa(pessoa), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{pessoaId}/enderecos")
    public ResponseEntity<Pessoa> addEnderecoToPessoa(@RequestBody Endereco endereco, @PathVariable(value = "pessoaId") Long pessoaId) {
        try {
            return new ResponseEntity<>(pessoaService.addEnderecoToPessoa(pessoaId, endereco), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(pessoaService.createOrUpdatePessoa(pessoa), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePessoa(@PathVariable Long id) {
        try {
            pessoaService.deletePessoa(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
