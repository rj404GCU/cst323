/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Nov 1, 2023
 * Activity 
 */
package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.OrderEntity;

/**
 * @author Rebecca Johnson
 *
 */
public class OrderRowMapper implements RowMapper<OrderEntity> {
	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNumber) throws SQLException
	{
		return new OrderEntity(rs.getLong("ID"), rs.getString("ORDER_NO"), rs.getString("PRODUCT_NAME"), rs.getFloat("PRICE"), rs.getInt("QUANTITY"));
	}

}
