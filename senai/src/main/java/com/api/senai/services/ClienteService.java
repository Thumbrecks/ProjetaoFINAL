package com.api.senai.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.senai.entities.Cliente;
import com.api.senai.repositories.ClienteRepository;

@Service
public class ClienteService {

// copiado de exercicio e adaptado

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }
    public Cliente getClienteById(Long id){

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        return cliente;
    }
    public Cliente saveCliente(Cliente novoCliente){

        Cliente cliente = clienteRepository.save(novoCliente);
        return cliente;
    }

// ERRO EM SETALL 

//     public Cliente updateCliente(Long id, Cliente clienteAtualizado){
        
//         Cliente clienteExistente = getClienteById(id);
//         clienteExistente.setAllAtributos(clienteAtualizado);
//         saveCliente(clienteExistente);
        
//         return clienteExistente;
//     }

    public Cliente deleteCliente(Long id){

        clienteRepository.deleteById(id);
        Cliente clienteDeletado = getClienteById(id);

        return clienteDeletado;
    }
    public Cliente logicalDeleteCliente(Long id){
        Cliente clienteExistente = getClienteById(id);
        clienteExistente.setAtivo(false);
        saveCliente(clienteExistente);

        return clienteExistente;
    }


    
}
