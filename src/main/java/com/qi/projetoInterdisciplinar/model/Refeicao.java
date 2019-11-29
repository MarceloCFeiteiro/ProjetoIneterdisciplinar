package com.qi.projetoInterdisciplinar.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "refeicao")
public class Refeicao {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "A identificação da instituição  é uma informação obrigatória.")
    private Long idInstituicao;

    @Lob
    @Column(nullable = false)
    @NotBlank(message = "A Descrição  é uma informação obrigatória.")
    private String descricao;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data de cadastro é uma informação obrigatória.")
    private Date dataCadastro;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data de refeição é uma informação obrigatória.")
    private Date dataRefeição;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Long idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataRefeição() {
        return dataRefeição;
    }

    public void setDataRefeição(Date dataRefeição) {
        this.dataRefeição = dataRefeição;
    }
}
