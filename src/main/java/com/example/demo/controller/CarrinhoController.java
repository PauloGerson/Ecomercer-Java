package com.example.demo.controller;

import com.example.demo.model.entity.Carrinho;
import com.example.demo.model.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Controller
@RequestMapping("compras")
public class CarrinhoController {

    @Autowired
    private Carrinho carrinho;

    /*@GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
       List<Produto> produtos = carrinho.getProdutos();
       model.addAttribute("produtos", produtos);
       return new ModelAndView("carrinho/list", model);
    }*/

    @GetMapping("/carrinho")
    public ModelAndView exibirCarrinho(Model model, HttpSession session) {
        List<Produto> produtos = carrinho.getProdutos();
        session.setAttribute("produtosCarrinho", produtos);
        model.addAttribute("produtos", produtos);
        return new ModelAndView("carrinho/list");
    }
}
