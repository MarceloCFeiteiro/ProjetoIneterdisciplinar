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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Long idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }
}
