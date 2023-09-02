package com.example.demo.repository;

import com.example.demo.model.Transacao;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
