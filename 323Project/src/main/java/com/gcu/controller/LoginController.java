package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("") //home
public class LoginController {
	@Autowired 
	OrdersBusinessServiceInterface service;
	
	@Autowired
	SecurityBusinessService security;
	
	
	@GetMapping("/")
	public String display(Model model)
	{		
		//Display login form view
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());

		return "login";
	}
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) 
	{
		security.authenticate(null, null);
		
		if(bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Login Form");
			service.test();

			//returns to login view
			return "login";
		}
		
		service.getOrders();
		
		//Print form values
		System.out.println(String.format("Form with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()));
		
		//Navigate back to Orders view
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		
		return "orders";
		
	}
}
