package com.api.senai.services;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.senai.entities.Conta;
import com.api.senai.entities.Operacao;
import com.api.senai.repositories.ContaRepository;
import com.api.senai.repositories.OperacaoRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private OperacaoRepository operacaoRepository;

    public List<Conta> getAllContas(){
        List<Conta> conta = contaRepository.findAll();

        return conta;
    }
    public Conta getContaById(Long id){

        Conta conta = contaRepository.findById(id).orElse(null);

        return conta;
    }
    public Conta saveConta(Conta novaConta){

        Conta conta = contaRepository.save(novaConta);
        return conta;
    }
    public Conta updateConta(Long id, Conta contaAtualizada){
        
        Conta contaExistente = getContaById(id);
        // contaExistente.setAllAtributos(contaAtualizada);
        saveConta(contaExistente);
        
        return contaExistente;
    }
    public Conta deleteConta(Long id){

        contaRepository.deleteById(id);
        Conta contaDeletada = getContaById(id);

        return contaDeletada;
    }
    public Conta logicalDeleteConta(Long id){
        Conta contaExistente = getContaById(id);
        contaExistente.setAtivo(false);
        saveConta(contaExistente);

        return contaExistente;
    }


    @Transactional
        public void realizarTransacao(Long contaOrigemId, Long contaDestinoId, BigDecimal valor) {
        Conta contaOrigem = contaRepository.findById(contaOrigemId).orElseThrow(() -> new RuntimeException("Conta origem não encontrada"));
        Conta contaDestino = contaRepository.findById(contaDestinoId).orElseThrow(() -> new RuntimeException("Conta destino não encontrada"));

        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente na conta origem");
        }

        // Atualiza o saldo nas contas
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        // Salva as alterações nas contas
        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);

        // Registra a transação no log
        Operacao operacao = new Operacao();
        operacao.setDataHora(LocalDateTime.now());
        operacao.setOrigem(contaOrigem);  // Usar a instância de contaOrigem
        operacao.setDestino(contaDestino);  // Usar a instância de contaDestino
        operacao.setTipoOperacao(null);
        operacao.setValor(valor);
        operacaoRepository.save(operacao);
    }
}

//Este código é um serviço de conta que implementa a lógica de negócios para contas bancárias. Ele fornece métodos para criar, ler, atualizar e excluir contas, bem como realizar transações entre contas.  
//O serviço é injetado com um repositório de contas e um repositório de operações. O repositório de contas é usado para armazenar e recuperar contas, enquanto o repositório de operações é usado para armazenar e recuperar transações. 
//O serviço implementa os seguintes métodos: 
//*  getAllContas() : Retorna uma lista de todas as contas no banco de dados. 
//*  getContaById(Long id) : Retorna uma conta específica com base no ID fornecido. 
//*  saveConta(Conta novaConta) : Salva uma nova conta no banco de dados. 
//*  updateConta(Long id, Conta contaAtualizada) : Atualiza uma conta existente no banco de dados. 
//*  deleteConta(Long id) : Exclui uma conta do banco de dados. 
//*  logicalDeleteConta(Long id) : Marca uma conta como excluída no banco de dados. 
//*  realizarTransacao(Long contaOrigemId, Long contaDestinoId, BigDecimal valor) : Realiza uma transação entre duas contas. 
//O serviço também implementa alguns métodos relacionados à lógica de negócios da conta, como calcular o saldo de uma conta e verificar se uma conta está ativa.
// Métodos relacionados à lógica de negócios da conta

    

