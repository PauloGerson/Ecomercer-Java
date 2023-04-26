package com.example.demo.controller;

import com.example.demo.model.entity.ItemVenda;
import com.example.demo.model.entity.Produto;
import com.example.demo.model.entity.Venda;
import com.example.demo.model.repository.ProdutoRepository;
import com.example.demo.model.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;


@Scope("request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {

   @Autowired
    VendaRepository repository;


   @Autowired
    Venda venda;

   @Autowired
   ProdutoRepository produtoRepository;
   @GetMapping("/list")

    public  ModelAndView listar(ModelMap model){
        model.addAttribute("vendas", repository.buscarVendas());
        return new ModelAndView("vendas/list", model);
   }

    @GetMapping("/carrinho")
    public String carrinho(Venda venda) {

        return "carrinho/carrinho";

    }



    @PostMapping("/add")
    public ModelAndView add(ItemVenda itemVenda) {
        if (venda == null) {
            throw new NullPointerException("Não foi possivel ");
        }

        Produto produto = produtoRepository.produto(itemVenda.getProduto().getId());

        itemVenda.setProduto(produto);
        
        venda.getVenda().add(itemVenda);


        return new ModelAndView("redirect:/vendas/carrinho");
    }

}
