package com.userService.co.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.Logger;
//import org.hibernate.annotations.common.util.impl.LoggerFactory;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.co.entities.User;
import com.userService.co.exceptions.ResourceNotFoundEx;
import com.userService.co.service.UserServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserServiceImpl serviceImpl;
	
	@PostMapping("/create")
	public ResponseEntity<User> createuser(@RequestBody User user ){
		User user1=serviceImpl.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUsers(){
		
	List<User> allUser=	serviceImpl.getUsers();
		return ResponseEntity.ok(allUser);
		//ResponseEntity.
		
	}
	
	int retryCount=1;
	@GetMapping("{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
	//now we will see wiith Retry
	//@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallBack")
	//now we will see rate limiter
	@RateLimiter(name ="ratingHotelLimiter",fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> getUser(@PathVariable String userId) throws ResourceNotFoundEx {
		logger.info("how many times method retried"+" "+retryCount);
		retryCount++;
		User user=new User();
		
			user = serviceImpl.getUserbyID(userId.trim());
	
			// TODO Auto-generated catch block
		
		return ResponseEntity.ok(user);
		
	}
	///creating fallbackMethod
public ResponseEntity<User> ratingHotelFallBack( String userId,Exception ex){
		logger.info("Rate Serice is down"+" "+ex.getMessage());
		User user=new User();
		user.setAbout("This is Fault dummy User");
		user.setName("Fault Name");
		user.setEmail("fault@test.com");
		 return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		
	}
}
