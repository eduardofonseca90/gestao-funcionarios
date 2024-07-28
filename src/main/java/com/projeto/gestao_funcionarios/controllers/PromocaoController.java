package com.projeto.gestao_funcionarios.controllers;

import com.projeto.gestao_funcionarios.model.Promocao;
import com.projeto.gestao_funcionarios.services.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promocoes")
public class PromocaoController {

    @Autowired
    private PromocaoService promocaoService;

    @GetMapping
    public ResponseEntity<List<Promocao>> getAllPromocoes() {
        List<Promocao> promocoes = promocaoService.findAll();
        return ResponseEntity.ok(promocoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promocao> getPromocaoById(@PathVariable Long id) {
        Optional<Promocao> promocao = promocaoService.findById(id);
        return promocao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Promocao> createPromocao(@RequestBody Promocao promocao) {
        Promocao savedPromocao = promocaoService.save(promocao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPromocao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promocao> updatePromocao(@PathVariable Long id, @RequestBody Promocao promocao) {
        if (!promocaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        promocao.setId(id);
        Promocao updatedPromocao = promocaoService.save(promocao);
        return ResponseEntity.ok(updatedPromocao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromocao(@PathVariable Long id) {
        if (!promocaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        promocaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
