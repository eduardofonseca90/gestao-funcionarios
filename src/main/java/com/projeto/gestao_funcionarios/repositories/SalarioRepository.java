package com.projeto.gestao_funcionarios.repositories;

import com.projeto.gestao_funcionarios.model.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Long>{

}
