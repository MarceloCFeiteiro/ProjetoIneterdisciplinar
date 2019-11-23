package com.qi.projetoInterdisciplinar.service;

import com.qi.projetoInterdisciplinar.model.Refeicao;
import com.qi.projetoInterdisciplinar.repository.RefeicaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefeicaoService {

    private RefeicaoRepository refeicaoRepository;

    public List<Refeicao> findAll() {
        return refeicaoRepository.findAll();
    }

    public Refeicao findOne(Long id) {

        Optional<Refeicao> byId = refeicaoRepository.findById(id);

        return byId.isPresent() ? byId.get() : new Refeicao();
    }

    public Refeicao save(Refeicao refeicao) {
        return refeicaoRepository.saveAndFlush(refeicao);
    }
}
