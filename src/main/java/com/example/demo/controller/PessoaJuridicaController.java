package com.example.demo.controller;


import com.example.demo.model.entity.Cidade;
import com.example.demo.model.entity.PessoaJuridica;
import com.example.demo.model.repository.CidadeRepository;
import com.example.demo.model.repository.EstadoRepository;
import com.example.demo.model.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Transactional
@Controller
@RequestMapping("pessoaJ")
public class PessoaJuridicaController {

    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @GetMapping("/form")
    public String form(PessoaJuridica pessoaJuridica, ModelMap modelMap){
        modelCidadeEstado(modelMap);
        modelMap.addAttribute("pessoaJuridica", new PessoaJuridica());
        return "pessoaJ/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoaJuridica", pessoaJuridicaRepository.buscarPessoaJ());
        return new ModelAndView("pessoaJ/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(PessoaJuridica pessoaJuridica, BindingResult result, ModelMap model){

        Cidade c = cidadeRepository.cidade(pessoaJuridica.getEndereco().get(0).getCidade().getId());
        pessoaJuridica.getEndereco().get(0).setCidade(c);
        pessoaJuridica.getEndereco().get(0).getCidade().setEstado(c.getEstado());
        pessoaJuridica.getEndereco().get(0).setPessoa(pessoaJuridica);
        pessoaJuridicaRepository.save(pessoaJuridica);
        return new ModelAndView("redirect:/pessoaJ/list");
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaJuridica pessoaJuridica) {
        Cidade c = cidadeRepository.cidade(pessoaJuridica.getEndereco().get(0).getCidade().getId());
        pessoaJuridica.getEndereco().get(0).setCidade(c);
        pessoaJuridica.getEndereco().get(0).getCidade().setEstado(c.getEstado());
        pessoaJuridica.getEndereco().get(0).setPessoa(pessoaJuridica);
        pessoaJuridicaRepository.update(pessoaJuridica);
        return new ModelAndView("redirect:/pessoaJ/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaJuridica", pessoaJuridicaRepository.pessoa(id));
        return new ModelAndView("pessoaJ/form", model);
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        pessoaJuridicaRepository.remove(id);
        return new ModelAndView("redirect:/pessoaJ/list");
    }

    private void modelCidadeEstado(ModelMap model){
        model.addAttribute("cidade", cidadeRepository.buscarCidade());
        model.addAttribute("estado", estadoRepository.buscarEstado());

    }

}
