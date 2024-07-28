package com.projeto.gestao_funcionarios.repositories;

import com.projeto.gestao_funcionarios.model.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long>{

}
