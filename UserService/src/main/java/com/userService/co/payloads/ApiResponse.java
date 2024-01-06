package com.userService.co.payloads;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
	
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(String message, boolean sucess, HttpStatus status) {
		super();
		this.message = message;
		this.sucess = sucess;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	private String message;
	
	private boolean sucess;
	
	private HttpStatus status;

}
