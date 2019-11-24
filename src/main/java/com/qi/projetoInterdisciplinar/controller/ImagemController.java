package com.qi.projetoInterdisciplinar.controller;

import com.qi.projetoInterdisciplinar.model.Imagem;
import com.qi.projetoInterdisciplinar.service.ImagemService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ImagemController {

    private ImagemService imagemService;

    //Vai para tela principal do CRUD aonde são listados todas as instituições
    @GetMapping("/imagem")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/imagem");
        mv.addObject("imagens", imagemService.findAll());

        return mv;
    }

    //Vai para tela de adição de imagem
    @GetMapping("/addImagem")
    public ModelAndView add(Imagem imagem) {

        ModelAndView mv = new ModelAndView("/imagemAdd");
        mv.addObject("imagem", imagem);

        return mv;
    }

    //Vai para tela de edição de imagens (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("/editImagem/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(imagemService.findOne(id));
    }

    //Exclui um imagem por seu ID e redireciona para a tela principal
    @GetMapping("/deleteImagem/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

//        imagemService.delete(id);

        return findAll();
    }

    //Recebe um objeto preenchido do Thymeleaf e valida
    //Se tudo estiver ok, salva e volta para tela principal
    //Se houver erro, retorna para tela atual exibindo as mensagens de erro
    @PostMapping("/saveImagem")
    public ModelAndView save(@Valid Imagem imagem, BindingResult result) {

        if(result.hasErrors()) {
            return add(imagem);
        }

        imagemService.save(imagem);

        return findAll();
    }




}
