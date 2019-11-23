package com.qi.projetoInterdisciplinar.repository;

import com.qi.projetoInterdisciplinar.model.Refeicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao,Long> {
}
