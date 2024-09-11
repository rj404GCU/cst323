/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Nov 1, 2023
 * Activity 
 */
package com.gcu.data;

import java.util.List;

public interface DataAccessInterface<T> {
	public List<T> findAll();
	public T findById(long id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
