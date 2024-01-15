package com.mvp.hotel.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String city;

    private String locality;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private Integer noOfRooms;

    private Integer noOfPersons;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fromDate;

//    public void setFromDate(Date fromDate) {
//        this.fromDate = fromDate;
//    }
//
//    public void setToDate(Date toDate) {
//        this.toDate = toDate;
//    }
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date toDate;

    private String roomType;
}
