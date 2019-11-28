package com.qi.projetoInterdisciplinar.controller;

import com.qi.projetoInterdisciplinar.model.Pessoa;
import com.qi.projetoInterdisciplinar.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    //Vai para tela principal do CRUD aonde são listados todas as pessoas
    @GetMapping("/pessoaList")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/pessoaList");
        mv.addObject("pessoas", pessoaService.findAll());

        return mv;
    }

    //Vai para tela de adição de pessoas
    @GetMapping("/addpessoa")
    public ModelAndView add(Pessoa pessoa) {

        ModelAndView mv = new ModelAndView("/pessoaAdd");
        mv.addObject("pessoa", pessoa);

        return mv;
    }

    //Vai para tela de edição de pessoas (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/editpessoa/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(pessoaService.findOne(id));
    }

    //Exclui um pessoa por seu ID e redireciona para a tela principal
    @GetMapping("/deletepessoa/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

       // pessoaService.delete(id);

        return findAll();
    }

    //Recebe um objeto preenchido do Thymeleaf e valida
    //Se tudo estiver ok, salva e volta para tela principal
    //Se houver erro, retorna para tela atual exibindo as mensagens de erro
    @PostMapping("/savepessaoa")
    public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) {

        if(result.hasErrors()) {
            return add(pessoa);
        }

        pessoaService.save(pessoa);

        return findAll();
    }

}
