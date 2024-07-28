package com.projeto.gestao_funcionarios.controllers;

import com.projeto.gestao_funcionarios.model.Cargo;
import com.projeto.gestao_funcionarios.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargos() {
        List<Cargo> cargos = cargoService.findAll();
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable Long id) {
        Optional<Cargo> cargo = cargoService.findById(id);
        return cargo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cargo> createCargo(@RequestBody Cargo cargo) {
        Cargo savedCargo = cargoService.save(cargo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable Long id, @RequestBody Cargo cargo) {
        if (!cargoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cargo.setId(id);
        Cargo updatedCargo = cargoService.save(cargo);
        return ResponseEntity.ok(updatedCargo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Long id) {
        if (!cargoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cargoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
