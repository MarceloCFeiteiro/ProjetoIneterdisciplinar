package com.qi.projetoInterdisciplinar.service;

import java.util.List;
import java.util.Optional;

import com.qi.projetoInterdisciplinar.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qi.projetoInterdisciplinar.model.Instituicao;

@Service
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository repository; //Injeta o repositório

    public List<Instituicao> findAll() {
        return repository.findAll();
    }

    public Instituicao findOne(Long id) {

        Optional<Instituicao> byId = repository.findById(id);

        return byId.isPresent() ? byId.get() : new Instituicao();
    }

    public Instituicao save(Instituicao instituicao) {
        return repository.saveAndFlush(instituicao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}