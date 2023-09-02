package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String numConta;


    public Conta(String numConta) {
        this.numConta = numConta;
    }

    public Conta() {

    }

    public void setNumConta(String numConta){
        this.numConta = numConta;
    }

    public Long getId() {
        return this.Id;
    }

    public String getNumConta(){
        return this.numConta;
    }
}
