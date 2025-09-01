package com.gcu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.validation.BindingResult;
import java.util.ArrayList;
import java.util.List;
import com.gcu.model.OrderModel;
import jakarta.validation.Valid;

import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/")
    public String display(Model model)
    {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bingindResult, Model model)
    {

        if (bingindResult.hasErrors())
        {
            model.addAttribute("title", "Login Form");
            return "login";
        }
       System.out.println(String.format("Form with username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword() ));
       
       
         List<OrderModel> orders = new ArrayList<OrderModel>();
       orders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
       orders.add(new OrderModel(1L, "0000000002", "Product 2", 2.00f, 2));
       orders.add(new OrderModel(2L, "0000000003", "Product 3", 3.00f, 3));
       orders.add(new OrderModel(3L, "0000000004", "Product 4", 4.00f, 4));
       orders.add(new OrderModel(4L, "0000000005", "Product 5", 5.00f, 5));

       model.addAttribute("title", "Order Listing");
       model.addAttribute("orders", orders);
       
        return "orders";
    }
    
}

