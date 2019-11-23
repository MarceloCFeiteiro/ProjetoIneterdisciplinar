package com.qi.projetoInterdisciplinar.service;

import java.util.List;
import java.util.Optional;

import com.qi.projetoInterdisciplinar.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qi.projetoInterdisciplinar.model.Instituicao;

@Service //Define a classe como um bean do Spring
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository repository; //Injeta o repositório

    //Retorna uma lista com todos posts inseridos
    public List<Instituicao> findAll() {
        return repository.findAll();
    }

    //Retorno um post a partir do ID
    public Instituicao findOne(Long id) {

        Optional<Instituicao> byId = repository.findById(id);

        return byId.isPresent() ? byId.get() : new Instituicao();
    }

    //Salva ou atualiza um post
    public Instituicao save(Instituicao post) {
        return repository.saveAndFlush(post);
    }

    //Exclui um post
    public void delete(Long id) {
        repository.deleteById(id);
    }
}