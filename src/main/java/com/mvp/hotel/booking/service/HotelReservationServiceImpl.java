package com.mvp.hotel.booking.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvp.hotel.booking.dto.ReservationDto;
import com.mvp.hotel.booking.entity.Reservation;
import com.mvp.hotel.booking.repository.HotelReservationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mvp.hotel.booking.util.ValidateUtil.isValidDateFormat;

@Service
public class HotelReservationServiceImpl implements HotelReservationService{

    private ObjectMapper objectMapper;
    private final HotelReservationRepository hotelReservationRepository;

    @Autowired
    public HotelReservationServiceImpl(HotelReservationRepository hotelReservationRepository) {
        this.hotelReservationRepository = hotelReservationRepository;
    }

    @PostConstruct
    void init(){
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public ReservationDto getDetailsById(Long userId) {
        Reservation reservation = hotelReservationRepository.findById(userId).orElse(null);
        return objectMapper.convertValue(reservation, ReservationDto.class);
    }

    @Override
    public String createReservation(ReservationDto request) {

        if (!isValidDateFormat(request.getFromDate()) || !isValidDateFormat(request.getToDate())) {
            throw new IllegalArgumentException("Invalid date format. Please use dd-MM-yyyy");
        }
        Reservation reservation = objectMapper.convertValue(request, Reservation.class);

        if (reservation.getFromDate().after(reservation.getToDate())){
            throw new RuntimeException("Invalid Request: toDate should be greater than fromDate");
        }
        try {
            hotelReservationRepository.saveAndFlush(reservation);
            return "reserved";
        }
        catch (Exception ex){
            System.out.println("Something went wrong: "+ex.getLocalizedMessage());
            return "reservation-failed";
        }

    }

    @Override
    public String cancelReservation(Long userId) {
        try {
            hotelReservationRepository.deleteById(userId);
            return "cancelled";
        }
        catch (Exception ex){
            System.out.println("Something went wrong: "+ex.getLocalizedMessage());
            return "cancellation-failed";
        }
    }
}
