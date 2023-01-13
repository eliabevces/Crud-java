package com.example.crud_pessoa.database;

import jakarta.persistence.*;
import com.example.crud_pessoa.models.Endereco;
import com.example.crud_pessoa.models.Pessoa;
import com.example.crud_pessoa.repositories.EnderecoRepository;
import com.example.crud_pessoa.repositories.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
        return args -> {
            Pessoa p1 = new Pessoa("Fulano", LocalDate.of(2000,8,21));
            Pessoa p2 = new Pessoa("Siclano", LocalDate.of(1982,2,10));
            Pessoa p3 = new Pessoa("Beltrano", LocalDate.of(2003,3,1));



            Endereco e1 = new Endereco("Rua 1", "38425684", 47, "São Paulo");
            Endereco e2 = new Endereco("Rua 2", "38478684", 9, "Rio de Janeiro");
            Endereco e3 = new Endereco("Rua 3", "38865184", 26, "São Paulo");
            Endereco e4 = new Endereco("Rua 4", "38414862", 8712, "Uberlandia");
            Endereco e5 = new Endereco("Rua 5", "12486324", 487, "Brasilia");
            Endereco e6 = new Endereco("Rua 6", "86219872", 2, "Anapolis");




            List<Endereco> enderecos = Arrays.asList(e1,e2);
            p1.setEnderecos(enderecos);


            enderecos = Arrays.asList(e3,e4);
            p2.setEnderecos(enderecos);


            enderecos = Arrays.asList(e5,e6);
            p3.setEnderecos(enderecos);

            enderecos = Arrays.asList(e1,e2,e3,e4,e5,e6);

            enderecoRepository.saveAll(enderecos);
            List<Pessoa> pessoas = Arrays.asList(p1, p2,p3);
            pessoaRepository.saveAll(pessoas);
        };
    }
}
