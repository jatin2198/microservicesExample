package com.ratingService.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ratingService.co.entities.Rating;
import com.ratingService.co.exceptions.ResourceNotFoundEx;
import com.ratingService.co.repos.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public Rating create(Rating r) {
		// TODO Auto-generated method stub
		return ratingRepository.save(r);
	}

	@Override
	public List<Rating> getAllratings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}
	/*
	 * @Override public Rating getRating(String UserId) throws ResourceNotFoundEx {
	 * // TODO Auto-generated method stub return
	 * ratingRepository.findById(UserId).orElseThrow(()->new
	 * ResourceNotFoundEx("no ratings found")); }return null;
	 */


	@Override
	public List<Rating> getRatingByUserID(String UserId)  {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(UserId);}

	@Override
	public List<Rating> getRatingByHotelId(String hoteld){
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hoteld);
	}

}
