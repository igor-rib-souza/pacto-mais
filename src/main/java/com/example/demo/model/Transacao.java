package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;

@Entity
public class Transacao {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long contaId;
    private Long tipoOperacaoId;
    private Double valor;
    private LocalDateTime dataTransacao;


    public  Transacao(){
        this.dataTransacao = LocalDateTime.now();
    }
    public Transacao(Long contaId, Long tipoOperacaoId, Double valor){
        this.contaId = contaId;
        this.tipoOperacaoId = tipoOperacaoId;
        this.valor = valor;
        this.dataTransacao = LocalDateTime.now();
    }

    public Long getId() {
        return this.Id;
    }

    public Double getValor() {
        return this.valor;
    }

    public Long getContaId() {
        return this.contaId;
    }

    public Long getTipoOperacaoId() {
        return this.tipoOperacaoId;
    }

    public LocalDateTime getDataTransacao() {
        return this.dataTransacao;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }
}
