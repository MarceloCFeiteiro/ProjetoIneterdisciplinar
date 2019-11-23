package com.qi.projetoInterdisciplinar.repository;

import com.qi.projetoInterdisciplinar.model.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem,Long> {
}
