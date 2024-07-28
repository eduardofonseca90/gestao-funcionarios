package com.projeto.gestao_funcionarios.controllers;

import com.projeto.gestao_funcionarios.model.AvaliacaoDesempenho;
import com.projeto.gestao_funcionarios.services.AvaliacaoDesempenhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoDesempenhoController {

    @Autowired
    private AvaliacaoDesempenhoService avaliacaoDesempenhoService;

    @GetMapping
    public ResponseEntity<List<AvaliacaoDesempenho>> getAllAvaliacoes() {
        List<AvaliacaoDesempenho> avaliacoes = avaliacaoDesempenhoService.findAll();
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoDesempenho> getAvaliacaoById(@PathVariable Long id) {
        Optional<AvaliacaoDesempenho> avaliacao = avaliacaoDesempenhoService.findById(id);
        return avaliacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AvaliacaoDesempenho> createAvaliacao(@RequestBody AvaliacaoDesempenho avaliacaoDesempenho) {
        AvaliacaoDesempenho savedAvaliacao = avaliacaoDesempenhoService.save(avaliacaoDesempenho);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAvaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoDesempenho> updateAvaliacao(@PathVariable Long id, @RequestBody AvaliacaoDesempenho avaliacaoDesempenho) {
        if (!avaliacaoDesempenhoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        avaliacaoDesempenho.setId(id);
        AvaliacaoDesempenho updatedAvaliacao = avaliacaoDesempenhoService.save(avaliacaoDesempenho);
        return ResponseEntity.ok(updatedAvaliacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvaliacao(@PathVariable Long id) {
        if (!avaliacaoDesempenhoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        avaliacaoDesempenhoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
