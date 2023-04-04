package com.example.demo.controller;

import com.example.demo.model.entity.Carrinho;
import com.example.demo.model.entity.Produto;
import com.example.demo.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Transactional
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProdutoRepository repository;
    @Autowired
    private Carrinho carrinho;




    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", repository.buscarProdutos());
        return new ModelAndView("home/list", model);
    }

    @GetMapping("/carrinho")
    public ModelAndView listarCarrinho(@RequestParam("id") long id, ModelMap model) {
        //model.addAttribute("produtos", repository.buscarProdutos());
        Produto produto = repository.produto(id);
        carrinho.adicionarProduto(produto);
        return new ModelAndView("carrinho/list", model);
    }





}
