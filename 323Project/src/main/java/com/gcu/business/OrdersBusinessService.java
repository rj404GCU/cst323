/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Oct 3, 2023
 * Activity 
 */
package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

/**
 * @author Rebecca Johnson
 *
 */
@Component
public class OrdersBusinessService implements OrdersBusinessServiceInterface {

	@Autowired
	OrderDataService service;
	
	@Override
	@Bean
	public void test() {
		System.out.println("Hello from the OrdersBusinessService ");
		
	}
	
	public List<OrderModel> getOrders() {
		
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		
		for(OrderEntity entity : ordersEntity)
		{
			//required so technology dependencies from the OrderEntity do not appear to the presentation layer
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		return ordersDomain;
	}
	
	public OrderModel getOrderById(long id) {
		
		OrderEntity orderEntity = service.findById(id);
		
		OrderModel orderModel = new OrderModel(orderEntity.getId(), orderEntity.getOrderNo(), orderEntity.getProductName(), orderEntity.getPrice(), orderEntity.getQuantity());

		return orderModel;
	}
	
	public OrderModel updateOrder(OrderModel orderModel) {
		
		OrderEntity orderEntity = new OrderEntity(orderModel.getId(), orderModel.getOrderNo(), orderModel.getProductName(), orderModel.getPrice(), orderModel.getQuantity());

		service.update(orderEntity);
		
		return orderModel;
	}
	
	/*
	 * Creates an order
	 * */
	public OrderModel createOrder(OrderModel orderModel) {
		
		OrderEntity orderEntity = new OrderEntity(null, orderModel.getOrderNo(), orderModel.getProductName(), orderModel.getPrice(), orderModel.getQuantity());

		service.create(orderEntity);
		
		return orderModel;
	}
	
	/*
	 * Deletes an order
	 * */
	public boolean deleteOrder(OrderModel orderModel) {
		
		OrderEntity orderEntity = new OrderEntity(null, orderModel.getOrderNo(), orderModel.getProductName(), orderModel.getPrice(), orderModel.getQuantity());
		
		return service.delete(orderEntity);
	}
	
	@PostConstruct
	public void init() {
		System.out.println(">>>> OrdersBusinessService init Method. ");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println(">>>> OrdersBusinessService destroy method. ");
	}

}
