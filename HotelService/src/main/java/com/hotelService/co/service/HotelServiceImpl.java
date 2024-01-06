package com.hotelService.co.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelService.co.entities.Hotel;
import com.hotelService.co.exceptions.ResourceNotFoundEx;
import com.hotelService.co.repos.HotelRepositoy;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepositoy hotelRepositoy;

	@Override
	public Hotel create(Hotel h) {
		// TODO Auto-generated method stub
		String ID=UUID.randomUUID().toString();
	     h.setHotelId(ID);
		return hotelRepositoy.save(h);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepositoy.findAll();
	}

	@Override
	public Hotel getHotelById(String Id) throws ResourceNotFoundEx {
		// TODO Auto-generated method stub
		return hotelRepositoy.findById(Id).orElseThrow(()->new  ResourceNotFoundEx("no hotel available"));
	}

}
