package com.example.demo.controller;

import com.example.demo.model.entity.ItemVenda;
import com.example.demo.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Transactional
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProdutoRepository repository;


    @GetMapping("/")
    public ModelAndView listar(ItemVenda itemVenda, ModelMap model) {
        model.addAttribute("produtos", repository.buscarProdutos());
        return new ModelAndView("home", model);
    }

}