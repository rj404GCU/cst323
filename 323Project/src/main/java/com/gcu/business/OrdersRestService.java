/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Oct 9, 2023
 * Activity 
 */
package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gcu.model.OrderModel;

/**
 * @author Rebecca Johnson
 *
 */
@RestController
@RequestMapping("/service")
public class OrdersRestService {
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@GetMapping(path="/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson()
	{
		return service.getOrders();
	}
	
	@GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
	public List<OrderModel> getOrdersAsXml()
	{
		return service.getOrders();
	}
	
	@GetMapping(path="/orders", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<OrderModel> getOrders()
	{
		return service.getOrders();
	}
}
