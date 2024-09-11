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
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.data.OrderDataService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/")
public class UpdateController {
	@Autowired 
	OrdersBusinessServiceInterface service;
	
	@Autowired
	SecurityBusinessService security;
	
	@Autowired
	OrdersBusinessService orderBusiness;	
	
	@GetMapping("update")
	public String display(@RequestParam("orderId") Long orderId, Model model)
	{		
		//Display login form view
		model.addAttribute("title", "Update Form");
		OrderModel orderModel = orderBusiness.getOrderById(orderId);
		model.addAttribute("orderModel", orderModel);

		return "update";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("orderId") Long orderId, Model model)
	{		
		//Display login form view
		model.addAttribute("title", "Update Form");
		OrderModel orderModel = orderBusiness.getOrderById(orderId);
		if(orderBusiness.deleteOrder(orderModel)) {
			System.out.println("Order Number: " + orderModel.getOrderNo() + " was Deleted.");
			model.addAttribute("error", "Order Deleted!");
		} else {
			System.out.println("ALERT: Order Number: " + orderModel.getOrderNo() + " was NOT Deleted.");
			model.addAttribute("error", "Failed to Update!");
		}
		model.addAttribute("orderModel", orderModel);

		//Navigate back to Orders view
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		
		
		return "orders";
	}
	
	@PostMapping("doUpdate")
	public String doUpdate(@Valid OrderModel orderModel, BindingResult bindingResult, Model model) 
	{
		security.authenticate(null, null);
		
		if(bindingResult.hasErrors()) 
		{
			model.addAttribute("title", "Update Form");
			model.addAttribute("error", "Failed to Update!");
			model.addAttribute("orderModel", orderModel);
			
			//returns to login view
			return "update";
		} else {
			//service.getOrders();
			model.addAttribute("error", "updated.");
			
			//updates order
			orderBusiness.updateOrder(orderModel);
			
			//Navigate back to Orders view
			model.addAttribute("title", "My Orders");
			model.addAttribute("orders", service.getOrders());
		}
		
		
		
		return "orders";
		
	}
}
