package com.qi.projetoInterdisciplinar.service;

import com.qi.projetoInterdisciplinar.model.Pessoa;
import com.qi.projetoInterdisciplinar.repository.PessoaReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaReposiroty pessoaReposiroty;

    public List<Pessoa> findAll(){
        return pessoaReposiroty.findAll();
    }

    public Pessoa findOne(Long id) {

        Optional<Pessoa> byId = pessoaReposiroty.findById(id);

        return byId.isPresent() ? byId.get() : new Pessoa();
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaReposiroty.saveAndFlush(pessoa);
    }


}
