package com.gcu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.validation.BindingResult;
import java.util.ArrayList;
import java.util.List;
import com.gcu.model.OrderModel;
import jakarta.validation.Valid;
import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;


import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private OrdersBusinessInterface service;    

    @Autowired
    private SecurityBusinessService security;

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
       
       service.test();
       security.authenticate(loginModel.getUsername(), loginModel.getPassword());
       
         List<OrderModel> orders = service.getOrders();

       model.addAttribute("title", "Order Listing");
       model.addAttribute("orders", orders);
       
        return "orders";
    }
    
}

