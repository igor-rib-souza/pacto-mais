package com.example.demo.service;

import com.example.demo.model.Conta;
import com.example.demo.model.LimiteConta;
import com.example.demo.repository.ContaRepository;
import com.example.demo.repository.LimiteContaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    @Autowired
    ContaRepository contaRepository;
    @Autowired
    LimiteContaRepository limiteContaRepository;

    public Conta criarConta(Conta conta){
        Conta contaAux = contaRepository.save(conta);
        limiteContaRepository.save(new LimiteConta(conta.getId()));
        return contaRepository.save(contaAux);
    }

    public Conta buscaId(Long id){
        return contaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CONTA NÃO ENCONTRADA"));
    }

}
