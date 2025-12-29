package com.hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@Setter
@Getter
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String location;
    private String about;
}
