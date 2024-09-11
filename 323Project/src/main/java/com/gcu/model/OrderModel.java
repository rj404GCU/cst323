package com.gcu.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderModel {
	
	@NotNull(message="Id is a required field")
	private long id;
	
	@NotNull(message="Order Number is a required field")
	@Size(min=1, max=32)
	private String orderNo;
	
	@NotNull(message="Product name is a required field")
	@Size(min=1, max=32, message="Product name must be between 1 and 32 characters")
	private String productName;
	
	@NotNull(message="Username is a required field")
	@DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "10000.0")
	private float price;
	
	@NotNull(message="Username is a required field")
	@Min(1)
	private int quantity;
	
	
	
	/**
	 * 
	 */
	public OrderModel() {
		super();
	}
	
	public OrderModel(long id, String orderNo, String productName, float price, int quantity) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	//Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}