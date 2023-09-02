package com.example.demo.controller;

import com.example.demo.model.LimiteConta;
import com.example.demo.model.Transacao;
import com.example.demo.repository.ContaRepository;
import com.example.demo.repository.LimiteContaRepository;
import com.example.demo.repository.TransacaoRepository;
import com.example.demo.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransacaoApiController {

    @Autowired
    TransacaoService transacaoService;
    @Autowired
    TransacaoRepository transacaoRepository;
    @Autowired
    ContaRepository contaRepository;
    @Autowired
    LimiteContaRepository limiteContaRepository;

    @PostMapping(value = "/transacao")
    public ResponseEntity<?> criaTransacao(@RequestBody Transacao transacao){
        try {
            LimiteConta limiteConta = limiteContaRepository.findById(transacao.getContaId()).get();


            if (contaRepository.findById(transacao.getContaId()).isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CONTA NÃO ENCONTRADA");
            }


            else if (limiteConta.getValor() < transacao.getValor() && transacao.getTipoOperacaoId() != 4){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("LIMITE INSUFICIENTE");
            }

            else if (transacao.getTipoOperacaoId() != 4) {
                transacao.setValor(transacao.getValor() * -1);
            }

            limiteConta.updateValor(transacao.getValor());
            LimiteConta updateLimite = limiteContaRepository.save(limiteConta);
            Transacao transacaoAux = transacaoRepository.save(transacao);
                return ResponseEntity.ok(transacaoAux);
        }

        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CONTA NÃO ENCONTRADA");
        }
    }
}
