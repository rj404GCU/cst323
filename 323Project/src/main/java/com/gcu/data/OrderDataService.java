/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Nov 1, 2023
 * Activity 
 */
package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

/**
 * @author Rebecca Johnson
 *
 */
@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>
{
	@Autowired
	private OrdersRepository ordersRepository;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	* Non-Default constructor for constructor injection.
	*/
	public OrderDataService (OrdersRepository ordersRepository, DataSource dataSource)
	{
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**	
	* CRUD: finder to return a single entity 
	* */
	public OrderEntity findById(long orderId)
	{
		try {
			Optional<OrderEntity> order= ordersRepository.findById((long) orderId);
			if (order.isPresent()) {
	            return order.get();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	*CRUD: finder to return all entities
	*/
	public List<OrderEntity> findAll()
	{
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		try
		{
			// Get all all the Entity Orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			// Convert to a List and return the List
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
		// Return the List
		return orders;
	}
	
	/**
	* CRUD: create an entity
	*/
	public boolean create(OrderEntity order)
	{
		//Example of "overriding" the CrudRepository save() because it simply is never called
		//You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method 
		String sql = "INSERT INTO orders (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";
		
		try
		{
			//Execute SQL Insert
			jdbcTemplateObject.update(sql,
			order.getOrderNo(),
			order.getProductName(), 
			order.getPrice(),
			order.getQuantity());
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(OrderEntity order) {
		//Locates record with the Order number and updates its fields
	    String sql = "UPDATE orders SET PRODUCT_NAME = ?, PRICE = ?, QUANTITY = ? WHERE ORDER_NO = ?";

	    try {
	        // Execute SQL Update
	        jdbcTemplateObject.update(sql,
	            order.getProductName(), 
	            order.getPrice(),
	            order.getQuantity(),
	            order.getOrderNo());
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}

	@Override
	public boolean delete(OrderEntity order) {
		//deletes the order with the given order number
		String sql = "DELETE FROM orders WHERE ORDER_NO = ?";
		try {
			int rows = jdbcTemplateObject.update(sql, order.getOrderNo());
			if(rows>= 1) return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
	
