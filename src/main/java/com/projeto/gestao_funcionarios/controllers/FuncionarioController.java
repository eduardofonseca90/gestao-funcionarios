package com.projeto.gestao_funcionarios.controllers;

import com.projeto.gestao_funcionarios.model.Funcionario;
import com.projeto.gestao_funcionarios.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.findById(id);
        return funcionario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario savedFuncionario = funcionarioService.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if (!funcionarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setId(id);
        Funcionario updatedFuncionario = funcionarioService.save(funcionario);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        if (!funcionarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
