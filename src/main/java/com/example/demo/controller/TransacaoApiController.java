package com.example.demo.controller;

import com.example.demo.model.Transacao;
import com.example.demo.service.TransacaoService;
import jakarta.persistence.EntityNotFoundException;
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

    @PostMapping(value = "/transacao")
    public ResponseEntity<?> criaTransacao(@RequestBody Transacao transacao){
        try {
            Transacao transacaoAux = transacaoService.criaTransacao(transacao);
            return ResponseEntity.ok(transacaoAux);
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERRO INTERNO DO SERVIDOR");
        }
    }
}
