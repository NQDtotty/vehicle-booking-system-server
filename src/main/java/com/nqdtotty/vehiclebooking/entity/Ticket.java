package com.nqdtotty.vehiclebooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @Column(name = "ticket_id", nullable = false)
    private String ticketId;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "seat_number", nullable = false)
    private int seatNumber;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "trip_id", nullable = false)
    private String tripId;

    @Column(name = "status", nullable = false)
    private String status;
}
