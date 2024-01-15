package com.mvp.hotel.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long userId;
    private String userEmail;
    private String city;
    private String locality;
    private String hotelName;
    private Integer noOfRooms;
    private Integer noOfPersons;
    private String fromDate;
    private String toDate;
    private String roomType;
}