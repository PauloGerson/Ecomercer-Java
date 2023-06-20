package com.example.demo.controller;

import com.example.demo.model.entity.Cidade;
import com.example.demo.model.entity.PessoaFisica;
import com.example.demo.model.entity.Produto;
import com.example.demo.model.repository.CidadeRepository;
import com.example.demo.model.repository.EstadoRepository;
import com.example.demo.model.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("pessoaF")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @GetMapping("/form")
    public String form(PessoaFisica pessoaFisica, ModelMap modelMap){
        modelCidadeEstado(modelMap);
        modelMap.addAttribute("pessoaFisica", new PessoaFisica());
        return "pessoaF/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoaFisica", pessoaFisicaRepository.buscarPessoaF());
        return new ModelAndView("pessoaF/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(PessoaFisica pessoaFisica, BindingResult result, ModelMap model){

        Cidade c = cidadeRepository.cidade(pessoaFisica.getEndereco().get(0).getCidade().getId());
        pessoaFisica.getEndereco().get(0).setCidade(c);
        pessoaFisica.getEndereco().get(0).getCidade().setEstado(c.getEstado());
        pessoaFisica.getEndereco().get(0).setPessoa(pessoaFisica);
        pessoaFisicaRepository.save(pessoaFisica);
        return new ModelAndView("redirect:/pessoaF/list");
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        pessoaFisicaRepository.update(pessoaFisica);
        return new ModelAndView("redirect:/pessoaF/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaFisica", pessoaFisicaRepository.pessoa(id));
        return new ModelAndView("pessoaF/form", model);
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        pessoaFisicaRepository.remove(id);
        return new ModelAndView("redirect:/pessoaF/list");
    }

    private void modelCidadeEstado(ModelMap model){
        model.addAttribute("cidade", cidadeRepository.buscarCidade());
        model.addAttribute("estado", estadoRepository.buscarEstado());

    }
}

