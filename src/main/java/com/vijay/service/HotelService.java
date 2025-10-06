package com.vijay.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.entity.Hotel;
import com.vijay.exception.ResourceNotFoundException;
import com.vijay.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // Save hotel
    public Hotel saveHotel(Hotel hotel) {
    	
       String hotelId=UUID.randomUUID().toString();
       hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    // Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Get hotel by ID
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
    }

    // Update hotel
//    public Hotel updateHotel(Long id, Hotel hotelDetails) {
//        Hotel hotel = hotelRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
//
//        hotel.setName(hotelDetails.getName());
//        hotel.setLocation(hotelDetails.getLocation());
//        hotel.setRating(hotelDetails.getRating());
//
//        return hotelRepository.save(hotel);
//    }

    // Delete hotel
    public void deleteHotel(String id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
        hotelRepository.delete(hotel);
    }
}
