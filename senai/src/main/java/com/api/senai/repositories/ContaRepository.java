package com.api.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.senai.entities.Conta;

@Repository
public interface ContaRepository  extends JpaRepository<Conta, Long>{
    
}
