package com.hotelService.co.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelService.co.entities.Hotel;
import com.hotelService.co.exceptions.ResourceNotFoundEx;
import com.hotelService.co.service.HotelServiceImpl;
//import com.userService.co.entities.User;

@RestController
@RequestMapping("/hotel")
public class HotelServiceController {
	
	@Autowired
	HotelServiceImpl hotelServiceImpl;
	
	@PostMapping("/create")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel htl=hotelServiceImpl.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(htl);
		
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>> getAllUsers(){
		
	List<Hotel> allUser=	hotelServiceImpl.getAllHotels();
		return ResponseEntity.ok(allUser);
		
	}
	@PostAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("{hotleId}")
	public ResponseEntity<Hotel> getUser(@PathVariable String hotleId) throws ResourceNotFoundEx{
		
		Hotel htl=hotelServiceImpl.getHotelById(hotleId);
		return ResponseEntity.ok(htl);
		
	}
	

}
