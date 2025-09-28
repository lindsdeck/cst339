package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import com.gcu.model.LoginModel;
import com.gcu.service.LoginService;

@Controller
public class LoginController {
    
    @Autowired
    private LoginService loginService;

   
    @GetMapping("/")
    public String home() {
        return "home";
    }

    
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                   @RequestParam(value = "logout", required = false) String logout,
                   Model model) {
    
        System.out.println("=== DEBUG: Login GET called, error=" + error + ", logout=" + logout);
                    
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password. Please try again.");
        }
    
        if (logout != null) {
            model.addAttribute("successMessage", "You have been successfully logged out.");
        }

        model.addAttribute("loginModel", new LoginModel());
    
        return "login";
    }

    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("loginModel", new LoginModel());
        model.addAttribute("title", "3DeDeck - Register");
        return "register";
    }

   
    @PostMapping("/register")
    public String processRegistration(@Valid LoginModel loginModel, 
                                    BindingResult bindingResult, 
                                    Model model,
                                    RedirectAttributes redirectAttributes) {
        
       
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "3DeDeck - Register");
            model.addAttribute("loginModel", loginModel);
            return "register";
        }

        try {
           
            boolean registrationSuccess = loginService.registerUser(loginModel);
            
            if (registrationSuccess) {
                redirectAttributes.addFlashAttribute("successMessage", 
                    "Registration successful! Please login with your new account.");
                return "redirect:/login";
            } else {
                model.addAttribute("errorMessage", 
                    "Registration failed. Username may already exist. Please try again.");
                model.addAttribute("title", "3DeDeck - Register");
                model.addAttribute("loginModel", new LoginModel());
                return "register";
            }
            
        } catch (Exception e) {
            // Log the error and show user-friendly message
            System.err.println("Registration error: " + e.getMessage());
            model.addAttribute("errorMessage", 
                "An error occurred during registration. Please try again.");
            model.addAttribute("title", "3DeDeck - Register");
            model.addAttribute("loginModel", new LoginModel());
            return "register";
        }
    }

   
    @GetMapping("/access-denied")
    public String accessDenied(Model model) {
        model.addAttribute("title", "Access Denied");
        model.addAttribute("message", "You don't have permission to access this resource.");
        return "error";
    }
}