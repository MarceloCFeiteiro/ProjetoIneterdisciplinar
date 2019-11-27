package com.qi.projetoInterdisciplinar.service;

import com.qi.projetoInterdisciplinar.model.Imagem;
import com.qi.projetoInterdisciplinar.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {



    @Autowired
    private ImagemRepository imagemRepository;

    public List<Imagem> findAll()
    {
        return imagemRepository.findAll();
    }

    public Imagem findOne(Long id) {

        Optional<Imagem> byId = imagemRepository.findById(id);

        return byId.isPresent() ? byId.get() : new Imagem();
    }

    public Imagem save(Imagem imagem){
        return imagemRepository.saveAndFlush(imagem);
    }

}
