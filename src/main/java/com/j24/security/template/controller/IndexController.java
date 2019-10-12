package com.j24.security.template.controller;

import com.j24.security.template.model.UserRegistrationRequest;
import com.j24.security.template.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/")
public class IndexController {

    @Autowired
    private String myNameBean;

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String getIndexPage(Model model){
        model.addAttribute("myName", myNameBean);
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login-form";
    }

    @GetMapping("/register")
    public String registrationForm(){
        return "registration-form";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationRequest request,
                           BindingResult bindingResult){
        if (!request.arePasswordEqual()){
            return "registration-form";
        }
        if (bindingResult.hasErrors()){
            return "registration-form";
        }
        if (!accountService.register(request)) {
            return "registration-form";
        }

        return "registration-form";
    }

}
