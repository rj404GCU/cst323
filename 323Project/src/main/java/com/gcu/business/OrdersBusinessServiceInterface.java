/**
 * Rebecca Johnson
 * cst 339
 * 10/3/2023
 * Activity 3
 */
package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

/**
 * @author Rebecca Johnson
 *
 */
public interface OrdersBusinessServiceInterface {

	//Abstract methods
	public void test();
	public List <OrderModel> getOrders();
	public void init();
	public void destroy();
}
