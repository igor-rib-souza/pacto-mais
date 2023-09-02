package com.example.demo.service;

import com.example.demo.model.LimiteConta;
import com.example.demo.repository.ContaRepository;
import com.example.demo.repository.LimiteContaRepository;
import com.example.demo.repository.TransacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Transacao;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;
    @Autowired
    ContaRepository contaRepository;
    @Autowired
    LimiteContaRepository limiteContaRepository;

    public Transacao criaTransacao(Transacao transacao) throws Exception{

        LimiteConta limiteConta = limiteContaRepository.findById(transacao.getContaId())
                .orElseThrow(() -> new EntityNotFoundException("CONTA NÃO ENCONTRADA"));

        if (contaRepository.findById(transacao.getContaId()).isEmpty()){
            throw new EntityNotFoundException("CONTA NÃO ENCONTRADA");
        }

        if (limiteConta.getValor() < transacao.getValor() && transacao.getTipoOperacaoId() != 4){
            throw new IllegalArgumentException("LIMITE INSUFICIENTE");
        }

        if (transacao.getTipoOperacaoId() != 4) {
            transacao.setValor(transacao.getValor() * -1);
        }

        limiteConta.updateValor(transacao.getValor());
        limiteContaRepository.save(limiteConta);
        return transacaoRepository.save(transacao);
    }
}

