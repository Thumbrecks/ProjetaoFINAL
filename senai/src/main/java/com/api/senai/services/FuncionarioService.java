package com.api.senai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.senai.entities.Funcionario;
import com.api.senai.repositories.FuncionarioRepository;

import java.util.List;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    
    public List<Funcionario> getAllFuncionarios(){
        List<Funcionario> funcionario = funcionarioRepository.findAll();

        return funcionario;
    }
    public Funcionario getFuncionarioById(Long id){

        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);

        return funcionario;
    }
    public Funcionario saveFuncionario(Funcionario novoFuncionario){

        Funcionario funcionario = funcionarioRepository.save(novoFuncionario);
        return funcionario;
    }
    public Funcionario updateFuncionario(Long id, Funcionario funcionarioAtualizado){
        
        Funcionario funcionarioExistente = getFuncionarioById(id);
        funcionarioExistente.setAllAtributos(funcionarioAtualizado);
        saveFuncionario(funcionarioExistente);
        
        return funcionarioExistente;
    }
    public Funcionario deleteFuncionario(Long id){

        funcionarioRepository.deleteById(id);
        Funcionario funcionarioDeletado = getFuncionarioById(id);

        return funcionarioDeletado;
    }
    public Funcionario logicalDeleteFuncionario(Long id){
        Funcionario funcionarioExistente = getFuncionarioById(id);
        funcionarioExistente.setAtivo(false);
        saveFuncionario(funcionarioExistente);

        return funcionarioExistente;
    }
}

/*Este código é um serviço de funcionário que implementa a lógica de negócios para funcionários. Ele fornece métodos para criar, ler, atualizar e excluir funcionários. 
 
O serviço é injetado com um repositório de funcionários, que é usado para armazenar e recuperar funcionários. 
 
O serviço implementa os seguintes métodos: 
 
-  getAllFuncionarios() : Retorna uma lista de todos os funcionários no banco de dados. 
-  getFuncionarioById(Long id) : Retorna um funcionário específico com base no ID fornecido. 
-  saveFuncionario(Funcionario novoFuncionario) : Salva um novo funcionário no banco de dados. 
-  updateFuncionario(Long id, Funcionario funcionarioAtualizado) : Atualiza um funcionário existente no banco de dados. 
-  deleteFuncionario(Long id) : Exclui um funcionário do banco de dados. 
-  logicalDeleteFuncionario(Long id) : Marca um funcionário como excluído no banco de dados. 
 
Esses métodos interagem com o repositório de funcionários para executar as operações correspondentes no banco de dados.*/