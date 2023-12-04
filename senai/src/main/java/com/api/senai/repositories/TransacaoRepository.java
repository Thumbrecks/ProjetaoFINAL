package com.api.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.senai.entities.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
    
}
