package com.hotel.services;

import com.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {
   public Hotel createHotel(Hotel hotel);
   public List<Hotel> getAllHotels();
   public Hotel getById(String id);
   public List<Hotel> searchHotels(String query);
}
