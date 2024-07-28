package com.projeto.gestao_funcionarios.repositories;

import com.projeto.gestao_funcionarios.model.AvaliacaoDesempenho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoDesempenhoRepository extends JpaRepository<AvaliacaoDesempenho, Long> {

}
