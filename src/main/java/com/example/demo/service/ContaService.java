package com.example.demo.service;

import com.example.demo.model.Conta;
import com.example.demo.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    @Autowired
    ContaRepository contaRepository;

    public Conta criarConta(String numConta){
        Conta conta = new Conta(numConta);
        return contaRepository.save(conta);
    }

    public Conta buscaId(Long id){
        return contaRepository.findById(id).orElseThrow();
    }

}
