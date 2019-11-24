package com.qi.projetoInterdisciplinar.controller;

import com.qi.projetoInterdisciplinar.model.Instituicao;
import com.qi.projetoInterdisciplinar.model.Refeicao;
import com.qi.projetoInterdisciplinar.service.RefeicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RefeicaoController {

    @Autowired
    private RefeicaoService refeicaoService;

    //Vai para tela principal do CRUD aonde são listados todas as refeicões
    @GetMapping("/")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/refeicao");
        mv.addObject("refeicoes", refeicaoService.findAll());

        return mv;
    }

    //Vai para tela de adição de refeicao
    @GetMapping("/add")
    public ModelAndView add(Refeicao refeicao) {

        ModelAndView mv = new ModelAndView("/refeicaoAdd");
        mv.addObject("refeicao", refeicao);

        return mv;
    }

    //Vai para tela de edição de refeicao (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(refeicaoService.findOne(id));
    }

    //Exclui um refeicao por seu ID e redireciona para a tela principal
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        //refeicaoService.delete(id);

        return findAll();
    }

    //Recebe um objeto preenchido do Thymeleaf e valida
    //Se tudo estiver ok, salva e volta para tela principal
    //Se houver erro, retorna para tela atual exibindo as mensagens de erro
    @PostMapping("/save")
    public ModelAndView save(@Valid Refeicao refeicao, BindingResult result) {

        if(result.hasErrors()) {
            return add(refeicao);
        }

        refeicaoService.save(refeicao);

        return findAll();
    }


}