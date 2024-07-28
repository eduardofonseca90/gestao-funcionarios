package com.projeto.gestao_funcionarios.services;

import com.projeto.gestao_funcionarios.model.AvaliacaoDesempenho;
import com.projeto.gestao_funcionarios.repositories.AvaliacaoDesempenhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoDesempenhoService {

    @Autowired
    private AvaliacaoDesempenhoRepository avaliacaoDesempenhoRepository;

    public List<AvaliacaoDesempenho> findAll() {
        return avaliacaoDesempenhoRepository.findAll();
    }

    public Optional<AvaliacaoDesempenho> findById(Long id) {
        return avaliacaoDesempenhoRepository.findById(id);
    }

    public AvaliacaoDesempenho save(AvaliacaoDesempenho avaliacaoDesempenho) {
        return avaliacaoDesempenhoRepository.save(avaliacaoDesempenho);
    }

    public void deleteById(Long id) {
        avaliacaoDesempenhoRepository.deleteById(id);
    }
}
