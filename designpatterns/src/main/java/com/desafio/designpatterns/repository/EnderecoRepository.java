package com.desafio.designpatterns.repository;

import com.desafio.designpatterns.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}