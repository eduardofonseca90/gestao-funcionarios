package com.projeto.gestao_funcionarios.services;

import com.projeto.gestao_funcionarios.model.Cargo;
import com.projeto.gestao_funcionarios.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    public Optional<Cargo> findById(Long id) {
        return cargoRepository.findById(id);
    }

    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public void deleteById(Long id) {
        cargoRepository.deleteById(id);
    }

}
