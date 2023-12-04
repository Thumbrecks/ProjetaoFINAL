

package com.api.senai.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.HttpStatus;
import com.api.senai.entities.Cliente;
import com.api.senai.services.ClienteService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping({"/clientes"}) // mapeia o endereco
public class ClienteController {

// copiado exercicio

 @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        
        List<Cliente> clientes = clienteService.getAllClientes();

        if(!clientes.isEmpty()) {
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(clientes, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Long id){
        
        Cliente cliente = clienteService.getClienteById(id);

        if (cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente novoCliente){

        Cliente cliente = clienteService.saveCliente(novoCliente);
        return ResponseEntity.ok(cliente);
    }
    // @PutMapping("/{id}")
    // public ResponseEntity<Cliente> updateCliente (@RequestBody Cliente clienteAtualizado, @PathVariable Long id) {

    //     Cliente cliente = clienteService.getClienteById(id);
    //     if (cliente != null){
    //         Cliente clienteNovo = clienteService.updateCliente(id, clienteAtualizado);
    //         return new ResponseEntity<>(clienteNovo, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
    //     }
    // }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){

        Cliente cliente = clienteService.getClienteById(id);
        
        if (cliente != null){
            clienteService.deleteCliente(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cliente> logicalDeleteCliente(@PathVariable Long id){

        Cliente cliente = clienteService.getClienteById(id);
        
        if (cliente != null){
            clienteService.logicalDeleteCliente(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }


    
}
