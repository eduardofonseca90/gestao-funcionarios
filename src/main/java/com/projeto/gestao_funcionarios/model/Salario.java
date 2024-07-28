package com.projeto.gestao_funcionarios.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Salario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private Date dataInicio;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

}
