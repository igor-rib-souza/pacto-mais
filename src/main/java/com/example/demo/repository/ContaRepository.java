package com.example.demo.repository;


import com.example.demo.model.Conta;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
