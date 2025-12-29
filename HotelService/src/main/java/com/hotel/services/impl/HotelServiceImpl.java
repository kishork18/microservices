package com.hotel.services.impl;

import com.hotel.entities.Hotel;
import com.hotel.repositories.HotelRepository;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        if(Objects.nonNull(hotel)){
            return hotelRepository.save(hotel);
        }
        throw new NullPointerException("Provided data is null");
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> list= hotelRepository.findAll();
        if (!list.isEmpty()){
            return list;
        }
        throw  new RuntimeException("List is empty");

    }

    @Override
    public Hotel getById(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new RuntimeException("Hotel Not found"));
    }
    
    @Override
    public List<Hotel> searchHotels(String query) {
        if (query == null || query.trim().isEmpty()) {
            return getAllHotels();
        }
        
        // Search in both name and location
        List<Hotel> nameMatches = hotelRepository.findByNameContainingIgnoreCase(query);
        List<Hotel> locationMatches = hotelRepository.findByLocationContainingIgnoreCase(query);
        
        // Combine results without duplicates
        Set<Hotel> uniqueHotels = new HashSet<>();
        uniqueHotels.addAll(nameMatches);
        uniqueHotels.addAll(locationMatches);
        
        return new ArrayList<>(uniqueHotels);
    }
}
