package com.api.senai.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OperacaoId;
    private String TipoOperacao; // saque deposito ou transferencia
    private BigDecimal valor;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn
    private Conta origem; // mapeado de conta

    @ManyToOne
    @JoinColumn
    private Conta destino; // mapeado de conta

    // APAGAR DEPOIS

    // public Operacao(String operacaoId, String tipoOperacao, String contaOrigem,
    // String contaDestino, String valor,
    // Timestamp data) {
    // OperacaoId = operacaoId;
    // TipoOperacao = tipoOperacao;
    // this.contaOrigem = contaOrigem;
    // this.contaDestino = contaDestino;
    // this.valor = valor;
    // this.data = data;
    // }

    // public String getOperacaoId() {
    // return OperacaoId;
    // }
    // public void setOperacaoId(String operacaoId) {
    // OperacaoId = operacaoId;
    // }
    // public String getTipoOperacao() {
    // return TipoOperacao;
    // }
    // public void setTipoOperacao(String tipoOperacao) {
    // TipoOperacao = tipoOperacao;
    // }
    // public String getContaOrigem() {
    // return contaOrigem;
    // }
    // public void setContaOrigem(String contaOrigem) {
    // this.contaOrigem = contaOrigem;
    // }
    // public String getContaDestino() {
    // return contaDestino;
    // }
    // public void setContaDestino(String contaDestino) {
    // this.contaDestino = contaDestino;
    // }
    // public String getValor() {
    // return valor;
    // }
    // public void setValor(String valor) {
    // this.valor = valor;
    // }
    // public Timestamp getData() {
    // return data;
    // }
    // public void setData(Timestamp data) {
    // this.data = data;
    // }

}
