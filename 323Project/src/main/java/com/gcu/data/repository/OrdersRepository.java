/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Nov 1, 2023
 * Activity 
 */
package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gcu.data.entity.OrderEntity;

/**
 * @author Rebecca Johnson
 *
 */
public interface OrdersRepository  extends CrudRepository<OrderEntity, Long>{

	//Example of truly overriding a method from the CRUDrepository & using customized SQL
	@Override
	@Query(value = "SELECT * FROM ORDERS")
	public List<OrderEntity> findAll();
	
	// Find an order by its ID using a custom query
    @Query("SELECT o FROM OrderEntity o WHERE o.id = :id")
    OrderEntity findOrderById(@Param("id") Long id);
}
