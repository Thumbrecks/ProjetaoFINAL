package com.api.senai.entities;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor // cria automaticamente um construtor com todos atributos da classe
@NoArgsConstructor // cria automaticamente um construtor vazio
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "cliente")
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    private String login;
    private String senha;
    private boolean ativo;
    private Timestamp dataExclusao;

    @OneToOne(mappedBy = "cliente")
    private Conta conta;

    // public Cliente(String nome, String cpf, Endereco endereco, Timestamp
    // dataNasc, String telefone, String email,
    // Timestamp dataCad, Conta conta, String clienteId, Timestamp dataExclusao,
    // Boolean ativo) {
    // super(nome, cpf, endereco, dataNasc, telefone, email, dataCad);
    // this.conta = conta;
    // this.clienteId = clienteId;
    // this.dataExclusao = dataExclusao;
    // this.ativo = ativo;
    // }

}
