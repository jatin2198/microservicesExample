package com.userService.co.externals.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userService.co.entities.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {
	
	@GetMapping("hotel/{hotelId}")
	public Hotel getHotel(@PathVariable String hotelId);

}
