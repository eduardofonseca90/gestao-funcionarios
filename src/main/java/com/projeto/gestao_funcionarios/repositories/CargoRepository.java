package com.projeto.gestao_funcionarios.repositories;

import com.projeto.gestao_funcionarios.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

}