package com.ratingService.co.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingService.co.entities.Rating;
import com.ratingService.co.exceptions.ResourceNotFoundEx;
import com.ratingService.co.service.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	RatingServiceImpl ratingServiceImpl;
	
	@PostMapping("/create")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		Rating rate=ratingServiceImpl.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rate);
		
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getAllRatings(){
		
	List<Rating> allrating=	ratingServiceImpl.getAllratings();
		return ResponseEntity.ok(allrating);
		
	}
	@PostAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("user/{ratingId}")
	///@NonNull
	public ResponseEntity<List<Rating>> getUserRating(@PathVariable  @NotNull String ratingId) throws ResourceNotFoundEx{
		
		List<Rating> allUserrate=ratingServiceImpl.getRatingByUserID(ratingId);
		return ResponseEntity.ok(allUserrate);
		
	}
	@PostAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("hotel/{ratingId}")
	public ResponseEntity<List<Rating>> getHotelRating(@PathVariable String ratingId) throws ResourceNotFoundEx{
		
		List<Rating> allUserrate=ratingServiceImpl.getRatingByHotelId(ratingId);
		return ResponseEntity.ok(allUserrate);
		
	}
	

}
