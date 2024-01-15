package com.mvp.hotel.booking.controller;

import com.mvp.hotel.booking.dto.ReservationDto;
import com.mvp.hotel.booking.service.HotelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "v1/hotel-reservation")
public class HotelReservationController {

    private final HotelReservationService hotelReservationService;

    @Autowired
    public HotelReservationController(HotelReservationService hotelReservationService) {
        this.hotelReservationService = hotelReservationService;
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReservationDto> getReservationDetailsById(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelReservationService.getDetailsById(userId));
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createReservation(@RequestBody ReservationDto request){
        return ResponseEntity.status(HttpStatus.OK).body(hotelReservationService.createReservation(request));
    }

    @DeleteMapping(value = "/remove")
    public ResponseEntity<String> cancelReservation(@RequestParam Map<String, String> request){
        Long userId = Long.valueOf(request.get("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(hotelReservationService.cancelReservation(userId));
    }

}
