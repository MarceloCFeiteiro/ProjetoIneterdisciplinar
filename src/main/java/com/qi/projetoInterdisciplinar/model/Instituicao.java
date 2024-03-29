package com.qi.projetoInterdisciplinar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity(name = "instituicao")
public class Instituicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Nome da instituição é uma informação obrigatória.")
    private String nome;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Endereço é uma informação obrigatória.")
    private String endereco;

    @Column(nullable = false)
    @NotBlank(message = "Email da instituição é uma informação obrigatória.")
    private String email;

    @Column(nullable = false)
    //  @Temporal(TemporalType.DATE)
    //  @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Telefone Instituição é uma informação obrigatória.")
    private String telefone;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
