package com.qi.projetoInterdisciplinar.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Imagem {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "A identificação da refeição  é uma informação obrigatória.")
    private Long idRefeicao;

    @Column(nullable = false)
    @NotBlank(message = "Foto é uma informação obrigatória.")
    private String foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(Long idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
