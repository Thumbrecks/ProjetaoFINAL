package com.api.senai.entities;

import java.time.LocalDateTime;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDateTime dataNasc;
    private String telefone;
    private String email;
    private LocalDateTime dataCad; // data cadastro

    // Abaixo para alinhar com o ViaCep

    @OneToOne
    @JoinColumn (name = "endereco", foreignKey = @ForeignKey(name = "endereco_fkey"))
    private Endereco endereco;
}
