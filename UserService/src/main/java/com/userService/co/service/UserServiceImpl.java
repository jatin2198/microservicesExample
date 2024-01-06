package com.userService.co.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.co.entities.Hotel;
import com.userService.co.entities.Rating;
import com.userService.co.entities.User;
import com.userService.co.exceptions.ResourceNotFoundEx;
import com.userService.co.externals.services.HotelService;
import com.userService.co.externals.services.RatingService;
import com.userService.co.repos.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	public HotelService hotelService;
	
	@Autowired
	public RatingService ratingService;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String ID=UUID.randomUUID().toString();
	     user.setUser_ID(ID);
	     //user.getRatings().stream().filter(i->i!=null).map(null)
	     
	     if(!user.getRatings().isEmpty()) {
	    	 user.getRatings().stream().map(i->{
	    		 i.setUserId(user.getUser_ID());
	    		 
	    		 return i;
	    		 }).collect(Collectors.toList()).forEach(i->ratingService.createRate(i));;
	     }
	    
		return userDao.save(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User updateUser(User c) {
		// TODO Auto-generated method stub
		return userDao.saveAndFlush(c);
	}

	@Override
	public User getUserbyID(String ID) throws ResourceNotFoundEx {
		// TODO Auto-generated method stub
		User user=userDao.findById(ID).orElseThrow(()->new ResourceNotFoundEx());
		
		//caling RatingService http://localhost:9001/ratings/user/118baddb-dda5-47e3-a16b-52fa2e1caa80
		//String url="http://RATINGSERVICE/ratings/user/"+ID.trim();
		//String hotelurl="http://HOTELSERVICE//hotel/";
		
		///Rating[] rats=restTemplate.getForObject(url, Rating[].class);
		
		//List<Rating> ratings=Arrays.stream(rats).toList();
			List<Rating> ratings=ratingService.getRatings(ID);
		if(ratings!=null) {
			
			///ratings.stream().filter(i->i.getHotelId()).forEach(i->);;
			
			for(Rating rate:ratings) {
				
				if(rate.getHotelId()!=null) {
		///Hotel hotel=restTemplate.getForObject(hotelurl+rate.getHotelId(), Hotel.class);
					Hotel hotel=hotelService.getHotel(rate.getHotelId());
		
		rate.setHotel(hotel);
				
			}}
		}
		user.setRatings(ratings);
		
		
	
	return user;
	}

	@Override
	public void deleteUser(String c) {
		// TODO Auto-generated method stub
		userDao.deleteById(c);
		
	}

}
