package com.qi.projetoInterdisciplinar.controller;

import javax.validation.Valid;

import com.qi.projetoInterdisciplinar.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qi.projetoInterdisciplinar.model.Instituicao;

@Controller
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    //Vai para tela principal do CRUD aonde são listados todas as instituições
    @GetMapping("/")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/instituicao");
        mv.addObject("instituicoes", instituicaoService.findAll());

        return mv;
    }

    //Vai para tela de adição de uma isntituicao
    @GetMapping("/add")
    public ModelAndView add(Instituicao instituicao) {

        ModelAndView mv = new ModelAndView("/instituicaoAdd");
        mv.addObject("instituicao", instituicao);

        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(instituicaoService.findOne(id));
    }

    //Exclui um instituicao por seu ID e redireciona para a tela principal
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        instituicaoService.delete(id);

        return findAll();
    }

    //Recebe um objeto preenchido do Thymeleaf e valida
    //Se tudo estiver ok, salva e volta para tela principal
    //Se houver erro, retorna para tela atual exibindo as mensagens de erro
    @PostMapping("/save")
    public ModelAndView save(@Valid Instituicao instituicao, BindingResult result) {

        if(result.hasErrors()) {
            return add(instituicao);
        }

       instituicaoService.save(instituicao);

        return findAll();
    }

}
