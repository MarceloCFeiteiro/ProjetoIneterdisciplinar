package com.matera.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matera.blog.model.Post;
import com.matera.blog.repository.PostRepository;

@Service //Define a classe como um bean do Spring
public class PostService {

    @Autowired
    private PostRepository repository; //Injeta o repositório

    //Retorna uma lista com todos posts inseridos
    public List<Post> findAll() {
        return repository.findAll();
    }

    //Retorno um post a partir do ID
    public Post findOne(Long id) {

        Optional<Post> byId = repository.findById(id);

        return byId.isPresent() ? byId.get() : new Post();
    }

    //Salva ou atualiza um post
    public Post save(Post post) {
        return repository.saveAndFlush(post);
    }

    //Exclui um post
    public void delete(Long id) {
        repository.deleteById(id);
    }
}