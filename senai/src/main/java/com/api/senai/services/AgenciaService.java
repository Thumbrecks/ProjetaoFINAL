package com.api.senai.services;

import java.util.List;
import com.api.senai.entities.Agencia;
import com.api.senai.repositories.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {
    
    @Autowired
    private final AgenciaRepository agenciaRepository;
    

    public AgenciaService(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public List<Agencia> getAllAgencias() {
        return agenciaRepository.findAll();
    }

    public Agencia getAgenciaById(String id) {
        return agenciaRepository.findById(id).orElse(null);
    }

    public Agencia saveAgencia(Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    public Agencia updateAgencia(String id, Agencia agenciaAtualizada) {
        Agencia agenciaExistente = agenciaRepository.findById(id).orElse(null);
        if (agenciaExistente != null) {
            // Update the properties of agenciaExistente with the values from agenciaAtualizada
            agenciaExistente.setAgenciaId(agenciaAtualizada.getAgenciaId());
            agenciaExistente.setEndereco(agenciaAtualizada.getEndereco());
            // Save the updated agenciaExistente
            return agenciaRepository.save(agenciaExistente);
        } else {
            return null;
        }
    }

    public void deleteAgencia(String id) {
        agenciaRepository.deleteById(id);
    }

    // Other methods for saving, updating, and deleting agencias
}