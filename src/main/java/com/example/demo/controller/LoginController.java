package com.example.demo.controller;

import com.example.demo.model.entity.ItemVenda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.Role;
import javax.transaction.Transactional;

@Transactional
@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping("/teste")
    public ModelAndView login( ModelMap model) {

        return new ModelAndView("home", model);
    }

}
