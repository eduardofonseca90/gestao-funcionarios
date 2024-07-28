package com.projeto.gestao_funcionarios.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Date dataContratacao;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Salario salario;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<AvaliacaoDesempenho> avaliacoes;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Promocao> promocoes;


}
