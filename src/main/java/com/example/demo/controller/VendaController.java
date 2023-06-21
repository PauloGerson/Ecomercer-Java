package com.example.demo.controller;

import com.example.demo.model.entity.*;
import com.example.demo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping("/list")

    public ModelAndView listar(ModelMap model) {
        model.addAttribute("vendas", repository.buscarVendas());
        model.addAttribute("titulo", "Lista das Vendas");
        return new ModelAndView("vendas/list", model);
    }

    @GetMapping("/carrinho")
    public String carrinho(Venda venda, ModelMap model) {

        model.addAttribute("titulo", "Produtos adicionados ao carrinho");
        modelAddPessoa(model);
        return "carrinho/list";

    }

    @PostMapping("/add")
    public ModelAndView add(ItemVenda itemVenda) {
        if (venda == null) {
            throw new NullPointerException("Não foi possivel ");
        }
        Produto produto = produtoRepository.produto(itemVenda.getProduto().getId());

        itemVenda.setProduto(produto);
        itemVenda.setVenda(venda);
        venda.getItens().add(itemVenda);
        return new ModelAndView("redirect:/vendas/carrinho");

    }

    @GetMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        for (ItemVenda item : venda.getItens()) {
            if (item.getId().equals(id)) {
                venda.getItens().remove(item);
                break;
            }
        }
        return new ModelAndView("redirect:/vendas/carrinho");
    }

    @GetMapping("/save")
    public ModelAndView save(){

        venda.setId(null);
       /* Pessoa p = pessoaFisicaRepository.pessoa(1L);
        venda.setPessoa(p);*/
        repository.save(venda);
        venda.getItens().clear();
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/itens/{id}")
    public ModelAndView getItensVenda(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("venda", repository.venda(id));
        return new ModelAndView("vendas/detalhes", model);
    }



    @GetMapping("/cart/{id}")
    public String endereco(@PathVariable("id") Long id, ModelMap model) {

        Pessoa p = pessoaRepository.pessoa(id);
        venda.setPessoa(p);
        model.addAttribute("endereco", p);
        modelAddPessoa(model);
        return "carrinho/list";
    }

    @GetMapping("/entrega/{id}")
    public String entrega(@PathVariable("id") Long id, ModelMap model){
        Endereco e = enderecoRepository.endereco(id);
        modelAddPessoa(model);
        return "carrinho/list";
    }



    private void modelAddPessoa(ModelMap modelMap){
        modelMap.addAttribute("pessoa", pessoaRepository.buscarPessoa());
    }


}
