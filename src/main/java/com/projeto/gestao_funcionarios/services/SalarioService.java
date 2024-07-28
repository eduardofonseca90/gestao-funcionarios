package com.projeto.gestao_funcionarios.services;

import com.projeto.gestao_funcionarios.model.Salario;
import com.projeto.gestao_funcionarios.repositories.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalarioService {
    @Autowired
    private SalarioRepository salarioRepository;

    public List<Salario> findAll() {
        return salarioRepository.findAll();
    }

    public Optional<Salario> findById(Long id) {
        return salarioRepository.findById(id);
    }

    public Salario save(Salario salario) {
        return salarioRepository.save(salario);
    }

    public void deleteById(Long id) {
        salarioRepository.deleteById(id);
    }
}
