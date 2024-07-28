package com.projeto.gestao_funcionarios.services;

import com.projeto.gestao_funcionarios.model.Promocao;
import com.projeto.gestao_funcionarios.repositories.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocaoService {

    @Autowired
    private PromocaoRepository promocaoRepository;

    public List<Promocao> findAll() {
        return promocaoRepository.findAll();
    }

    public Optional<Promocao> findById(Long id) {
        return promocaoRepository.findById(id);
    }

    public Promocao save(Promocao promocao) {
        return promocaoRepository.save(promocao);
    }

    public void deleteById(Long id) {
        promocaoRepository.deleteById(id);
    }
}
