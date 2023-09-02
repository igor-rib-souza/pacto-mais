package com.example.demo.service;

import com.example.demo.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Transacao;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    public Transacao criaTransacao(Long contaId, Long tipoOperacaoId, Double valor){

        Transacao transacao = new Transacao(contaId, tipoOperacaoId, valor);
        return transacaoRepository.save(transacao);
    }
}
