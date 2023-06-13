package com.nqdtotty.vehiclebooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @Column(name = "vehicle_id", nullable = false)
    private String vehicleId;

    @Column(name = "license_plate", nullable = false)
    private String licensePlate;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "seat", nullable = false)
    private int seat;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    @Column(name = "status", nullable = false)
    private String status;
}
