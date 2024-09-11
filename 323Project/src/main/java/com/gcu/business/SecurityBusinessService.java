/**
 * Rebecca Johnson
 * CST 339 - JAVA III
 * Oct 5, 2023
 * Activity 
 */
package com.gcu.business;

import org.springframework.stereotype.Service;

/**
 * @author Rebecca Johnson
 *
 */
@Service
public class SecurityBusinessService {
	
	public boolean authenticate(String username, String password) {
		System.out.println("Hello from the SecurityBusinessService");
		return true;
	}
}
