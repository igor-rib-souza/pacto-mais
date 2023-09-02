package com.example.demo;

import com.example.demo.repository.ContaRepository;
import com.example.demo.repository.LimiteContaRepository;
import com.example.demo.service.ContaService;
import com.example.demo.model.Conta;
import com.example.demo.model.LimiteConta;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService contaService;

    @Mock
    private ContaRepository contaRepository;

    @Mock
    private LimiteContaRepository limiteContaRepository;

    @Test
    public void testCriarConta() {
        Conta conta = new Conta();
        when(contaRepository.save(any(Conta.class))).thenReturn(conta);
        when(limiteContaRepository.save(any(LimiteConta.class))).thenReturn(new LimiteConta());

        Conta result = contaService.criarConta(conta);
        assertEquals(conta, result);
    }

    @Test
    public void testBuscaIdNotFound() {
        when(contaRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            contaService.buscaId(1L);
        });
    }
}
