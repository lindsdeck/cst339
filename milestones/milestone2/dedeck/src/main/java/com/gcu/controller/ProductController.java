package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;     
import javax.validation.Valid;
import com.gcu.model.CategoryModel;
import com.gcu.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Products");
        model.addAttribute("categoryModel", new CategoryModel());
        return "products";
    }

    @GetMapping("/manage")
    public String manage(Model model) {
        model.addAttribute("title", "Manage Inventory");
        model.addAttribute("categoryModel", new CategoryModel());
        return "manage";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Add Inventory");
        model.addAttribute("categoryModel", new CategoryModel());
        return "add";
    }

    @PostMapping("/add")
public String addProduct(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model) {
    System.out.println("addProduct method called");
    
    if(bindingResult.hasErrors()) {
        System.out.println("Validation errors found:");
        bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        model.addAttribute("title", "Add Inventory");
        model.addAttribute("categoryModel", categoryModel);
        return "add";
    }
    
    System.out.println("Attempting to add product: " + categoryModel.getName());
    
    if(productService != null) {
        System.out.println("ProductService is available");
        if(productService.addProduct(categoryModel)) {
            System.out.println(String.format("Product successfully added - Category: %s, Name: %s, Price: %.2f, Quantity: %d", 
                categoryModel.getCategory(), categoryModel.getName(), 
                categoryModel.getPrice(), categoryModel.getQuantity()));
            return "redirect:/products/manage?success=true";
        } else {
            model.addAttribute("error", "Failed to add product. Please try again.");
            model.addAttribute("title", "Add Inventory");
            model.addAttribute("categoryModel", categoryModel);
            return "add";
        }
    } else {
        System.out.println("ERROR: ProductService is null!");
        model.addAttribute("error", "Service unavailable. Please try again.");
        model.addAttribute("title", "Add Inventory");
        model.addAttribute("categoryModel", categoryModel);
        return "add";
    }
}

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("title", "Edit Inventory");
        model.addAttribute("categoryModel", new CategoryModel());
        return "edit";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        model.addAttribute("title", "Delete Inventory");
        model.addAttribute("categoryModel", new CategoryModel());
        return "delete";
    }

    @PostMapping("/practical")
    public String practical(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Products");
            model.addAttribute("categoryModel", categoryModel);
            return "products";
        }
        
        return "redirect:/practical";
    }

    @PostMapping("/fun")
    public String fun(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Products");
            model.addAttribute("categoryModel", categoryModel);
            return "products";
        }
        return "redirect:/fun";
    }

    @PostMapping("/collectibles")
    public String collectibles(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Products");
            model.addAttribute("categoryModel", categoryModel);
            return "products";
        }
        
        return "redirect:/collectibles";
    }
    
    @PostMapping("/manage")
    public String managePost(@Valid CategoryModel categoryModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Manage Inventory");
            model.addAttribute("categoryModel", categoryModel);
            return "manage";
        }
        
        return "redirect:/products/manage";
    }
}