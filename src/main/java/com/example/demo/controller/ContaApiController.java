package com.example.demo.controller;

import com.example.demo.model.Conta;
import com.example.demo.model.LimiteConta;
import com.example.demo.repository.ContaRepository;
import com.example.demo.repository.LimiteContaRepository;
import com.example.demo.service.ContaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ContaApiController {

    @Autowired
    ContaService contaService;
    @Autowired
    ContaRepository contaRepository;
    @Autowired
    LimiteContaRepository limiteContaRepository;

    @PostMapping(value = "/conta")
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta){
        Conta contaAux = contaService.criarConta(conta);
        return ResponseEntity.ok(contaAux);
    }


    @GetMapping(value="/conta/{contaId}")
    public ResponseEntity<?> buscaContaId(@PathVariable Long contaId){
        try {
            Conta conta = contaService.buscaId(contaId);
            return ResponseEntity.ok(conta);
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CONTA NÃO ENCONTRADA");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERRO INTERNO DO SERVIDOR");
        }
    }
}
