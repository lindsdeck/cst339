package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;     
import javax.validation.Valid;
import com.gcu.model.CategoryModel;
import com.gcu.model.LoginModel;


@Controller
@RequestMapping("/products")
public class ProductController 
{
    
    @GetMapping("/")
    public String display(Model model)
    {
        model.addAttribute("title", "Products");
        model.addAttribute("categoryModel", new CategoryModel());
        return "products";
    }

    @PostMapping("/practical")
    public String practical(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Login");
            model.addAttribute("categoryModel", categoryModel);
            return "login";
        }
        
        return "redirect:/success";
    }

    @PostMapping("/fun")
    public String fun(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Login");
            model.addAttribute("categoryModel", categoryModel);
            return "login";
        }
        return "redirect:/success";
    }

    @PostMapping("/collectibles")
    public String collectibles(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("title", "Login");
            model.addAttribute("categoryModel", categoryModel);
            return "login";
        }
        
        return "redirect:/success";
    }
    
}
