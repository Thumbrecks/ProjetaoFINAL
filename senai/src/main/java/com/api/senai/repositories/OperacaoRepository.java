package com.api.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.senai.entities.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    
}
