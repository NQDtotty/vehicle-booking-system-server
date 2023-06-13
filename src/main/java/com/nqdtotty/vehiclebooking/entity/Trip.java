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
@Table(name = "trips")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @Column(name = "trip_id", nullable = false)
    private String tripId;

    @Column(name = "vehicle_id", nullable = false)
    private String vehicleId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "route_id", nullable = false)
    private String routeId;

    @Column(name = "station_id", nullable = false)
    private String stationId;

    @Column(name = "status", nullable = false)
    private String status;
}
