package com.mvp.hotel.booking.repository;

import com.mvp.hotel.booking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelReservationRepository extends JpaRepository<Reservation, Long> {
}
