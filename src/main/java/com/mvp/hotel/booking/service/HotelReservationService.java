package com.mvp.hotel.booking.service;

import com.mvp.hotel.booking.dto.ReservationDto;

public interface HotelReservationService {
    ReservationDto getDetailsById(Long UserId);
    String createReservation(ReservationDto request);
    String cancelReservation(Long userId);
}
