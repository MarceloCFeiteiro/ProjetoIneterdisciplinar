package com.qi.projetoInterdisciplinar.repository;

import com.qi.projetoInterdisciplinar.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaReposiroty extends JpaRepository<Pessoa,Long> {
}
