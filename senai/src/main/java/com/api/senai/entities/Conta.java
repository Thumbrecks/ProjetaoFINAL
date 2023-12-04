package com.api.senai.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import lombok.Data;

@Data
@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contaId;
    private String numeroConta;
    private String tipo;
    private BigDecimal saldo;
    private Timestamp dataAbertura;
    private Timestamp dataEncerr;
    private boolean ativo;
    
    @OneToOne
    @JoinColumn(name = "agencia", foreignKey = @ForeignKey(name = "agencia_fkey"))
    private Agencia agencia;
    
    @OneToOne
    @JoinColumn(name = "conta_cliente", foreignKey = @ForeignKey(name = "conta_cliente_fkey"))
    private Cliente cliente;
    
    @OneToMany(mappedBy = "origem")
    private List<Operacao> operacoesOrigem;

    @OneToMany(mappedBy = "destino")
    private List<Operacao> operacoesDestino;

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
        
}
    // <-

    // APAGAR DEPOIS

    // public Conta(String conta, Agencia agenciaId, String tipo, String saldo,
    // Timestamp dataAbertura,
    // Timestamp dataEncerr) {
    // this.conta = conta;
    // this.agenciaId = agenciaId;
    // this.tipo = tipo;
    // this.saldo = saldo;
    // this.dataAbertura = dataAbertura;
    // this.dataEncerr = dataEncerr;
    // }

    // public String getConta() {
    // return conta;
    // }
    // public void setConta(String conta) {
    // this.conta = conta;
    // }
    // public Agencia getAgenciaId() {
    // return agenciaId;
    // }
    // public void setAgenciaId(Agencia agenciaId) {
    // this.agenciaId = agenciaId;
    // }
    // public String getTipo() {
    // return tipo;
    // }
    // public void setTipo(String tipo) {
    // this.tipo = tipo;
    // }
    // public String getSaldo() {
    // return saldo;
    // }
    // public void setSaldo(String saldo) {
    // this.saldo = saldo;
    // }
    // public Timestamp getDataAbertura() {
    // return dataAbertura;
    // }
    // public void setDataAbertura(Timestamp dataAbertura) {
    // this.dataAbertura = dataAbertura;
    // }
    // public Timestamp getDataEncerr() {
    // return dataEncerr;
    // }
    // public void setDataEncerr(Timestamp dataEncerr) {
    // this.dataEncerr = dataEncerr;
    // }

