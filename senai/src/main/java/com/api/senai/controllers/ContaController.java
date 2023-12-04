package com.api.senai.controllers;

import com.api.senai.entities.Conta;
import com.api.senai.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    
    @Autowired
    private final ContaService contaService;

    
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getAllContas() {
        List<Conta> contas = contaService.getAllContas();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
        Conta conta = contaService.getContaById(id);
        if (conta != null) {
            return new ResponseEntity<>(conta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Conta> saveConta(@RequestBody Conta novaConta) {
        Conta conta = contaService.saveConta(novaConta);
        return new ResponseEntity<>(conta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody Conta contaAtualizada) {
        Conta contaExistente = contaService.getContaById(id);
        if (contaExistente != null) {
            Conta contaAtualizadaResult = contaService.updateConta(id, contaAtualizada);
            return new ResponseEntity<>(contaAtualizadaResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long id) {
        Conta conta = contaService.getContaById(id);
        if (conta != null) {
            contaService.deleteConta(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/logical-delete/{id}")
    public ResponseEntity<Void> logicalDeleteConta(@PathVariable Long id) {
        Conta conta = contaService.getContaById(id);
        if (conta != null) {
            contaService.logicalDeleteConta(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> realizarTransacao(@RequestParam Long contaOrigemId,
                                                  @RequestParam Long contaDestinoId,
                                                  @RequestParam BigDecimal valor) {
        try {
            contaService.realizarTransacao(contaOrigemId, contaDestinoId, valor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

// Rodrigo Torres
/*
Neste exemplo, o  ContaController  é responsável por mapear as rotas relacionadas a contas bancárias e chamar os métodos adequados do  ContaService  para lidar com as operações. 
 
Os principais métodos são: 
 
-  getAllContas() : Retorna todas as contas existentes. 
-  getContaById(Long id) : Retorna uma conta específica com base no ID fornecido. 
-  saveConta(Conta novaConta) : Salva uma nova conta. 
-  updateConta(Long id, Conta contaAtualizada) : Atualiza uma conta existente. 
-  deleteConta(Long id) : Exclui uma conta. 
-  logicalDeleteConta(Long id) : Marca uma conta como excluída. 
-  realizarTransacao(Long contaOrigemId, Long contaDestinoId, BigDecimal valor) : Realiza uma transação entre duas contas. 
 
Observe que no método  realizarTransacao , os parâmetros são passados como  RequestParam  em vez de  RequestBody , pois são valores simples e não um objeto JSON completo. */