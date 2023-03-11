package com.example.demo.controller;

import com.example.demo.model.entity.Produto;
//import com.example.demo.model.entity.Venda;
import com.example.demo.model.repository.ProdutoRepository;
import com.example.demo.model.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {

   @Autowired
    VendaRepository repository;

   @GetMapping("/list")

    public  ModelAndView listar(ModelMap model){
        model.addAttribute("vendas", repository.buscarVendas());
        return new ModelAndView("vendas/list", model);
   }

}
