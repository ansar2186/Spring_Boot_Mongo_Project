package com.ansar.springbootmongodb.exception;

import org.springframework.context.annotation.Bean;

public class StudentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public StudentException(String msg) {
		super(msg);
	}
	
	@Bean
	public static String studentAlreadyExit() {
		return "Student already exit";
	}
	
	@Bean
	public static String studentNotFound(String id) {
		
		return "Student not found found with the ID: " +id;
		
	}

}
