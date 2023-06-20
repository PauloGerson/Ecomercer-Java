package com.example.demo.controller;

import com.example.demo.model.entity.Endereco;
import com.example.demo.model.entity.Estado;
import com.example.demo.model.repository.CidadeRepository;
import com.example.demo.model.repository.EnderecoRepository;
import com.example.demo.model.repository.EstadoRepository;
import com.example.demo.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Transactional
@Controller
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessosasRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("endereco", enderecoRepository.buscarEndereco());
        model.addAttribute("titulo", "Lista de Endereços");
        return new ModelAndView("pessoaF/list", model);
    }

    @GetMapping("/form")
    public String form(Endereco endereco, ModelMap model) {
        modelCidade(model);
        return "pessoaF/form";
    }

    @PostMapping("/save")
    public String save(Endereco endereco, @RequestParam("idpessoa") Long idP , @RequestParam("endereco[0].nomeCidade") Long idC , BindingResult result , ModelMap model) {
        var p = pessosasRepository.pessoa(idP);
        endereco.setPessoa(p);

        var city = cidadeRepository.cidade(idC);
        endereco.setCidade(city);

        enderecoRepository.save(endereco);

        return "pessoaF/list";
    }

//    @GetMapping("/remove/{id}")
//    public ModelAndView remove(@PathVariable("id") Long id) {
//        enderecosRepository.remove(id);
//        return new ModelAndView("redirect:/pessoa/pf/list");
//    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
//        model.addAttribute("endereco", enderecosRepository.endereco(id));
//        return new ModelAndView("/pessoa/pf/form", model);
//    }

//    @PostMapping("/update")
//    public ModelAndView update(Endereco endereco) {
//        enderecosRepository.update(endereco);
//        return new ModelAndView("redirect:/pessoa/pf/list");
//    }

    private void modelCidade(ModelMap model) {
        model.addAttribute("cidades", cidadeRepository.buscarCidade());
        model.addAttribute("estados", estadoRepository.buscarEstado());
    }

}
