package com.hotel.controllers;

import com.hotel.entities.Hotel;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
         String id= UUID.randomUUID().toString();
         hotel.setHotelId(id);
         Hotel hotel1= hotelService.createHotel(hotel);
         return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id){
        Hotel hotel = hotelService.getById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(
            @RequestParam String query,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder) {
        
        List<Hotel> hotels = hotelService.searchHotels(query);
        
        // Apply sorting if requested
        if (sortBy != null && !sortBy.isEmpty()) {
            hotels = sortHotels(hotels, sortBy, sortOrder);
        }
        
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
    
    private List<Hotel> sortHotels(List<Hotel> hotels, String sortBy, String sortOrder) {
        Comparator<Hotel> comparator = null;
        
        switch (sortBy.toLowerCase()) {
            case "name":
                comparator = Comparator.comparing(Hotel::getName);
                break;
            case "location":
                comparator = Comparator.comparing(Hotel::getLocation);
                break;
            default:
                return hotels; // No sorting if invalid sort field
        }
        
        // Apply sort direction
        if ("desc".equalsIgnoreCase(sortOrder)) {
            comparator = comparator.reversed();
        }
        
        return hotels.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
