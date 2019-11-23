package com.qi.projetoInterdisciplinar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Nome é uma informação obrigatória.")
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "A identificação da instituição  é uma informação obrigatória.")
    private Long idInstituicao;

    @Column(nullable = false)
    @NotBlank(message = "Email é uma informação obrigatória.")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Celular é uma informação obrigatória.")
    private String Celular;
}
