package com.projeto.gestao_funcionarios.controllers;

import com.projeto.gestao_funcionarios.model.Salario;
import com.projeto.gestao_funcionarios.services.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salarios")
public class SalarioController {

    @Autowired
    private SalarioService salarioService;

    @GetMapping
    public ResponseEntity<List<Salario>> getAllSalarios() {
        List<Salario> salarios = salarioService.findAll();
        return ResponseEntity.ok(salarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salario> getSalarioById(@PathVariable Long id) {
        Optional<Salario> salario = salarioService.findById(id);
        return salario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Salario> createSalario(@RequestBody Salario salario) {
        Salario savedSalario = salarioService.save(salario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSalario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salario> updateSalario(@PathVariable Long id, @RequestBody Salario salario) {
        if (!salarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        salario.setId(id);
        Salario updatedSalario = salarioService.save(salario);
        return ResponseEntity.ok(updatedSalario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalario(@PathVariable Long id) {
        if (!salarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        salarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
