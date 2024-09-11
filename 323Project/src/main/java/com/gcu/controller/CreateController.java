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

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/")
public class CreateController {
	@Autowired 
	OrdersBusinessServiceInterface service;
	
	@Autowired
	SecurityBusinessService security;
	
	@Autowired
	OrdersBusinessService orderBusiness;
	
	@GetMapping("/create")
	public String display(Model model, OrderModel orderModel)
	{		
		if (orderModel == null) {
	            orderModel = new OrderModel(0, "", "", 0, 0);
	    }
		 
		//Display login form view
		model.addAttribute("title", "Create Form");
		model.addAttribute("orderModel", orderModel);

		return "create";
	}
	
	@PostMapping("/doCreate")
	public String doCreate(@Valid OrderModel orderModel, BindingResult bindingResult, Model model) 
	{
		security.authenticate(null, null);
		
		if(bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Create Form");
			model.addAttribute("orderModel", orderModel);
			//service.test();

			//returns to login view
			return "create";
		}

		//Creates order
		orderBusiness.createOrder(orderModel);
		
		//Navigate back to Orders view
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		
		return "orders";
		
	}
}
