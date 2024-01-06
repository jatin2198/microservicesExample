package com.userService.co.externals.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.userService.co.entities.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {

	@GetMapping("ratings/user/{userId}")
	List<Rating> getRatings(@PathVariable String userId);
	
	@PostMapping("/ratings/create")
	public Rating createRate(@RequestBody Rating rating);
}
