/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Oct 3, 2023
 * Activity 3
 */
package com.gcu.business;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gcu.model.OrderModel;

/**
 * @author Rebecca Johnson
 *
 */
//@Component
public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface {

	@Override
	@Bean
	public void test() {
		System.out.println("Hello from the AnotherOrdersBusinessService. ");
		
	}
	
	public ArrayList<OrderModel> getOrders() {
		
		ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
		//List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "00000002", "Product 2", 2.00f, 1));
		orders.add(new OrderModel(2L, "00000003", "Product 3", 3.00f, 1));
		orders.add(new OrderModel(3L, "00000004", "Product 4", 4.00f, 1));
		orders.add(new OrderModel(4L, "00000005", "Product 5", 5.00f, 1));
		//orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
		return orders;
	}
	@PostConstruct
	public void init() {
		System.out.println(">>>> AnotherOrdersBusinessService init Method. ");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println(">>>> AnotherOrdersBusinessService destroy method. ");
	}


}
