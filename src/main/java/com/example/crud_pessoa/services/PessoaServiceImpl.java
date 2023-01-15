package com.example.crud_pessoa.services;

import com.example.crud_pessoa.models.Endereco;
import com.example.crud_pessoa.models.Pessoa;
import com.example.crud_pessoa.repositories.EnderecoRepository;
import com.example.crud_pessoa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl  implements PessoaService{

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public List<Pessoa> getPessoas() {
        List<Pessoa> p = pessoaRepository.findAll();
        System.out.println(p);
        return p;
    }

    @Override
    public Optional<Pessoa> getPessoaById(Long pessoaId){
        return pessoaRepository.findById(pessoaId);
    }

    @Override
    public Pessoa createOrUpdatePessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }


    @Override
    public Pessoa addEnderecoToPessoa(Long pessoaId,Endereco endereco){
        Optional<Pessoa> p = pessoaRepository.findById(pessoaId);
        if (p.isPresent()){
            Pessoa pessoa = p.get();
            pessoa.addEndereco(endereco);
            enderecoRepository.save(endereco);
            return pessoaRepository.save(pessoa);
        }

        return null;
    }

    @Override
    public void deletePessoa(Long pessoaId){
        pessoaRepository.delete(pessoaRepository.getReferenceById(pessoaId));
    }

}
