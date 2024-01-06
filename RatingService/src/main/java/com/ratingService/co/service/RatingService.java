package com.ratingService.co.service;

import java.util.List;

import com.ratingService.co.entities.Rating;
import com.ratingService.co.exceptions.ResourceNotFoundEx;

public interface RatingService {
	
	public Rating create(Rating r);
	
	public List<Rating> getAllratings();
	
	
	public List<Rating> getRatingByUserID(String UserId) ;
	public List<Rating> getRatingByHotelId(String hoteld) ;

}
