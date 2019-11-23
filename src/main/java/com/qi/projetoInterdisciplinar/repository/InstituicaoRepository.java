package com.qi.projetoInterdisciplinar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qi.projetoInterdisciplinar.model.Instituicao;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> { }
