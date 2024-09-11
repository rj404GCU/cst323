/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Oct 9, 2023
 * Activity 
 */
package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author Rebecca Johnson
 *
 */
@JacksonXmlRootElement(localName="orders")
public class OrderList {
	private List<OrderModel> orders = new ArrayList<OrderModel>();
	
	//@XmlElement(name="order")
	public List<OrderModel> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderModel> orders) {
		this.orders = orders;
	}
}
