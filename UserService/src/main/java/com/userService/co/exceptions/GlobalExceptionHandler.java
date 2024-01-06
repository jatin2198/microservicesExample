package com.userService.co.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userService.co.payloads.ApiResponse;

//import com.userService.co.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundEx.class)
	public ResponseEntity<ApiResponse> noResouceFoundExceptionHandler(ResourceNotFoundEx ex){
		
		String message=ex.getMessage();
		//ApiResponse.class.se
		ApiResponse response=new ApiResponse();
		response.setMessage(message);
		response.setSucess(true);
		response.setStatus(HttpStatus.NOT_FOUND);
	
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);}

}
