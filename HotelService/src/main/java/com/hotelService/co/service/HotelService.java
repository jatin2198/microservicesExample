package com.hotelService.co.service;

import java.util.List;

import com.hotelService.co.entities.Hotel;
import com.hotelService.co.exceptions.ResourceNotFoundEx;

public interface HotelService {
	
	public Hotel create(Hotel h);
	
	public List<Hotel>getAllHotels();
	
	public Hotel getHotelById(String Id) throws ResourceNotFoundEx;

}
