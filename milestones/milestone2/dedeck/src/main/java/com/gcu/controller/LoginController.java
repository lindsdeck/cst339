package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;     
import javax.validation.Valid;
import com.gcu.model.LoginModel;
import com.gcu.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(LoginModel loginModel, Model model) 
    {
        System.out.println(String.format("Login accepted for user: %s", loginModel.getUsername()));
        return "redirect:/products/";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Login");
            model.addAttribute("loginModel", loginModel);
            return "login";
        }
        
        if(loginService.registerUser(loginModel)) {
            model.addAttribute("registrationSuccess", "Registration successful! Please log in.");
            System.out.println(String.format("Registration successful - Name: %s %s, Email: %s, Phone: %s, Username: %s", 
                loginModel.getFirstName(), loginModel.getLastName(), loginModel.getEmail(), 
                loginModel.getPhone(), loginModel.getUsername()));
        } else {
            model.addAttribute("registrationError", "Registration failed. Please try again.");
        }
        
        model.addAttribute("title", "Login");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }
}