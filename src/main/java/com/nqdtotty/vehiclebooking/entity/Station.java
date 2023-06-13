package com.nqdtotty.vehiclebooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    @Id
    @Column(name = "station_id", nullable = false)
    private String stationId;

    @Column(name = "station_start", nullable = false)
    private String stationStart;

    @Column(name = "station_end", nullable = false)
    private String stationEnd;

    @Column(name = "status", nullable = false)
    private String status;
}
