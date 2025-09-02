package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;     
import javax.validation.Valid;
import com.gcu.model.LoginModel;


@Controller
@RequestMapping("/login")
public class LoginController 
{
    @GetMapping("/")
    public String display(Model model)
    {
        model.addAttribute("title", "Login");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Login");
            model.addAttribute("loginModel", loginModel);
            return "login";
        }
        
        System.out.println(String.format("Login Submitted: %s, %s", loginModel.getUsername(), loginModel.getPassword()));
        
        return "redirect:/success";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Login");
            model.addAttribute("loginModel", loginModel);
            return "login";
        }
        
        System.out.println(String.format("Registration attempt - Name: %s %s, Email: %s, Phone: %s, Username: %s", loginModel.getFirstName(), loginModel.getLastName(), loginModel.getEmail(),  loginModel.getPhone(), loginModel.getUsername()));
        return "redirect:/Success";

    }
}
