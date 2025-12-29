package com.hotel.repositories;

import com.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,String> {
    List<Hotel> findByNameContainingIgnoreCase(String name);
    List<Hotel> findByLocationContainingIgnoreCase(String location);
}
