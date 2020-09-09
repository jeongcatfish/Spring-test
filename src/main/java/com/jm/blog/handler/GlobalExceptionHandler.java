package com.jm.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // 모든 Exception이 발생하면 GolbalExceptionHandler 클래스로 들어옴
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String handleArgumentException(Exception e) {
		return "<h1>" + e.getMessage() +"</h1>";
	}
	
	
}
