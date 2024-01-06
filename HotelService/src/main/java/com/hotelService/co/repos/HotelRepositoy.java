package com.hotelService.co.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelService.co.entities.Hotel;

@Repository
public interface HotelRepositoy extends JpaRepository<Hotel, String> {

}
