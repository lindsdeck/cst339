package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.gcu.model.CategoryModel;
import com.gcu.service.ProductService;
import java.util.List;
import java.util.ArrayList;


@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    
    
    @GetMapping("/")
    public String display(Model model) {
        // Get all products for display
        try {
            List<CategoryModel> products = productService.getAllProducts();
            model.addAttribute("products", products);
        } catch (Exception e) {
            System.err.println("Error fetching products: " + e.getMessage());
            model.addAttribute("products", java.util.Collections.emptyList());
        }
        
        model.addAttribute("title", "3DeDeck - All Products");
        model.addAttribute("categoryModel", new CategoryModel());
        return "products";
    }

    @GetMapping("/all")
    public String displayAll(Model model)
    {
        List<CategoryModel> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("title", "3DeDecker - All Products");
        return "ProductDisplay";
    }
    
    @GetMapping("/category/{category}")
    public String displayByCategory(@PathVariable String category, Model model) {
      try 
      {
           String lowercaseCategory = category.toLowerCase();
             List<CategoryModel> products = productService.getProductsByCategory(lowercaseCategory); // Using lowercaseCategory here
             model.addAttribute("products", products);
        } 
        catch (Exception e) 
        {
            System.err.println("Error fetching products by category: " + e.getMessage());
            model.addAttribute("products", java.util.Collections.emptyList());
        }
    
        model.addAttribute("title", "3DeDeck - " + category + " Products");
        model.addAttribute("category", category);
        model.addAttribute("categoryModel", new CategoryModel());
        return "ProductDisplay";
    }
    
    @GetMapping("/detail/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        try {
            CategoryModel product = productService.getProductById(id);
            if (product != null) {
                model.addAttribute("title", "3DeDeck - " + product.getName());
                model.addAttribute("product", product);
                return "product-detail";
            }
        } catch (Exception e) {
            System.err.println("Error fetching product detail: " + e.getMessage());
        }
        return "redirect:/products/";
    }
    
    @GetMapping("/search")
    public String searchProducts(@RequestParam("query") String query, Model model) {
        try {
            List<CategoryModel> products = productService.searchProducts(query);
            model.addAttribute("products", products);
        } catch (Exception e) {
            System.err.println("Error searching products: " + e.getMessage());
            model.addAttribute("products", java.util.Collections.emptyList());
        }
        
        model.addAttribute("title", "3DeDeck - Search Results");
        model.addAttribute("searchQuery", query);
        model.addAttribute("categoryModel", new CategoryModel());
        return "products";
    }

    

    @GetMapping("/manage")
    public String manage(Model model) 
    {
        List<CategoryModel> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("title", "Manage Inventory");
        return "manage";
    }

    // Create a new Product

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Add Inventory");
        model.addAttribute("categoryModel", new CategoryModel());
        model.addAttribute("isEdit", false);
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid CategoryModel categoryModel, 
                           BindingResult bindingResult, 
                           Model model,
                           RedirectAttributes redirectAttributes) {
        System.out.println("addProduct method called");
        
        if(bindingResult.hasErrors()) {
            System.out.println("Validation errors found:");
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            model.addAttribute("title", "Add Inventory");
            model.addAttribute("categoryModel", categoryModel);
            model.addAttribute("isEdit", false);
            return "add";
        }
        
        System.out.println("Attempting to add product: " + categoryModel.getName());
        
        if(productService != null) {
            System.out.println("ProductService is available");
            if(productService.addProduct(categoryModel)) {
                System.out.println(String.format("Product successfully added - Category: %s, Name: %s, Price: %.2f, Quantity: %d", 
                    categoryModel.getCategory(), categoryModel.getName(), 
                    categoryModel.getPrice(), categoryModel.getQuantity()));
                redirectAttributes.addFlashAttribute("successMessage", 
                    "Product '" + categoryModel.getName() + "' added successfully!");
                return "redirect:/products/manage";
            } else {
                model.addAttribute("error", "Failed to add product. Please try again.");
                model.addAttribute("title", "Add Inventory");
                model.addAttribute("categoryModel", categoryModel);
                model.addAttribute("isEdit", false);
                return "add";
            }
        } else {
            System.out.println("ERROR: ProductService is null!");
            model.addAttribute("error", "Service unavailable. Please try again.");
            model.addAttribute("title", "Add Inventory");
            model.addAttribute("categoryModel", categoryModel);
            model.addAttribute("isEdit", false);
            return "add";
        }
    }

    // Edit an existing Product

   @GetMapping("/edit")
public String edit(Model model) {
    try {
        List<CategoryModel> products = productService.getAllProducts();
        model.addAttribute("products", products);
    } catch (Exception e) {
        System.err.println("Error fetching products for edit: " + e.getMessage());
        model.addAttribute("products", java.util.Collections.emptyList());
    }
    
    model.addAttribute("title", "Edit Inventory");
    model.addAttribute("categoryModel", new CategoryModel());
    return "edit";
}
    
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        try {
            CategoryModel product = productService.getProductById(id);
            if (product != null) {
                model.addAttribute("title", "Edit Inventory - " + product.getName());
                model.addAttribute("categoryModel", product);
                model.addAttribute("isEdit", true);
                return "add"; // Reuse the add form for editing
            }
        } catch (Exception e) {
            System.err.println("Error fetching product for edit: " + e.getMessage());
        }
        return "redirect:/products/manage";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id,
                              @Valid CategoryModel categoryModel,
                              BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Edit Inventory");
            model.addAttribute("categoryModel", categoryModel);
            model.addAttribute("isEdit", true);
            return "add";
        }
        
        categoryModel.setId(id);
        try {
            boolean success = productService.updateProduct(categoryModel);
            
            if(success) {
                redirectAttributes.addFlashAttribute("successMessage", 
                    "Product '" + categoryModel.getName() + "' updated successfully!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", 
                    "Failed to update product. Please try again.");
            }
        } catch (Exception e) {
            System.err.println("Error updating product: " + e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", 
                "An error occurred while updating the product.");
        }
        
        return "redirect:/products/manage";
    }

//Delete existing products

   @GetMapping("/delete")
public String delete(Model model) {
    try {
        List<CategoryModel> products = productService.getAllProducts();
        model.addAttribute("products", products);
    } catch (Exception e) {
        System.err.println("Error fetching products for delete: " + e.getMessage());
        model.addAttribute("products", java.util.Collections.emptyList());
    }
    
    model.addAttribute("title", "Delete Inventory");
    model.addAttribute("categoryModel", new CategoryModel());
    return "delete";
}
    
    @GetMapping("/delete/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        try {
            CategoryModel product = productService.getProductById(id);
            if (product != null) {
                model.addAttribute("title", "Delete Inventory - " + product.getName());
                model.addAttribute("product", product);
                return "delete";
            }
        } catch (Exception e) {
            System.err.println("Error fetching product for delete: " + e.getMessage());
        }
        return "redirect:/products/manage";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, 
                              RedirectAttributes redirectAttributes) {
        
        try {
            CategoryModel product = productService.getProductById(id);
            boolean success = productService.deleteProduct(id);
            
            if(success && product != null) {
                redirectAttributes.addFlashAttribute("successMessage", 
                    "Product '" + product.getName() + "' deleted successfully!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", 
                    "Failed to delete product. Please try again.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting product: " + e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", 
                "An error occurred while deleting the product.");
        }
        
        return "redirect:/products/manage";
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