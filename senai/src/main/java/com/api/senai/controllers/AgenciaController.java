package com.api.senai.controllers;

import com.api.senai.entities.Agencia;
import com.api.senai.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {

    @Autowired
    private final AgenciaService agenciaService;

    
    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    @GetMapping
    public ResponseEntity<List<Agencia>> getAllAgencias() {
        List<Agencia> agencias = agenciaService.getAllAgencias();
        return new ResponseEntity<>(agencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agencia> getAgenciaById(@PathVariable String id) {
        Agencia agencia = agenciaService.getAgenciaById(id);
        if (agencia != null) {
            return new ResponseEntity<>(agencia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Agencia> saveAgencia(@RequestBody Agencia novaAgencia) {
        Agencia agencia = agenciaService.saveAgencia(novaAgencia);
        return new ResponseEntity<>(agencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agencia> updateAgencia(@PathVariable String id, @RequestBody Agencia agenciaAtualizada) {
        Agencia agenciaExistente = agenciaService.getAgenciaById(id);
        if (agenciaExistente != null) {
            Agencia agenciaAtualizadaResult = agenciaService.updateAgencia(id, agenciaAtualizada);
            return new ResponseEntity<>(agenciaAtualizadaResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgencia(@PathVariable String id) {
        Agencia agencia = agenciaService.getAgenciaById(id);
        if (agencia != null) {
            agenciaService.deleteAgencia(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

/*o  AgenciaController  é responsável por mapear as rotas relacionadas a agências e chamar os métodos adequados do  AgenciaService  para lidar com as operações. 
 
Os principais métodos são: 
 
-  getAllAgencias() : Retorna todas as agências existentes. 
-  getAgenciaById(String id) : Retorna uma agência específica com base no ID fornecido. 
-  saveAgencia(Agencia novaAgencia) : Salva uma nova agência. 
-  updateAgencia(String id, Agencia agenciaAtualizada) : Atualiza uma agência existente. 
-  deleteAgencia(String id) : Exclui uma agência.  */