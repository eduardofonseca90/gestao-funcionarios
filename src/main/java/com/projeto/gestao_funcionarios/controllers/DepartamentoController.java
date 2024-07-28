package com.projeto.gestao_funcionarios.controllers;

import com.projeto.gestao_funcionarios.model.Departamento;
import com.projeto.gestao_funcionarios.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        List<Departamento> departamentos = departamentoService.findAll();
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoService.findById(id);
        return departamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento) {
        Departamento savedDepartamento = departamentoService.save(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        if (!departamentoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        departamento.setId(id);
        Departamento updatedDepartamento = departamentoService.save(departamento);
        return ResponseEntity.ok(updatedDepartamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id) {
        if (!departamentoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        departamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
