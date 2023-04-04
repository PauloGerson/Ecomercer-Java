package com.example.demo.controller;

/*  Anotation  */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*  imports  */
import com.example.demo.model.entity.Produto;
import com.example.demo.model.repository.ProdutoRepository;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import javax.transaction.Transactional;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/form")
    public String form(Produto produtos){
        return "produtos/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", repository.buscarProdutos());
        return new ModelAndView("produtos/list", model);
    }

    @GetMapping ("/search")
    public ModelAndView buscar(ModelMap model , @RequestParam("id") Long id){
        model.addAttribute("produtos", repository.produto(id));

        return new ModelAndView("produtos/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        repository.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }

    /**
     * @param id
     * @return
     * @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
     */
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", repository.produto(id));
        return new ModelAndView("produtos/form", model);
    }



    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        repository.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }
}
