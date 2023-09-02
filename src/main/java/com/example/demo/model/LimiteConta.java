package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class LimiteConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long contaId;
    private Double valor;
    private LocalDate dataLimite;

    public LimiteConta(){
        this.dataLimite = LocalDate.now().plusMonths(1);
    }

    public LimiteConta(Long contaId, Double valor){
        this.contaId = contaId;
        this.valor = valor;
        this.dataLimite = LocalDate.now().plusMonths(1);
    }

    public LimiteConta(Long contaId){
        this.contaId = contaId;
        this.valor = 0.00;
        this.dataLimite = LocalDate.now().plusMonths(1);
    }

    public Long getId() {
        return this.Id;
    }

    public Long getContaId() {
        return this.contaId;
    }

    public Double getValor() {
        return this.valor;
    }

    public LocalDate getDataLimite() {
        return this.dataLimite;
    }

    public void updateValor(Double valor) {
        this.valor += valor;
    }
}
