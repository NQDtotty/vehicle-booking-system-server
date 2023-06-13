package com.nqdtotty.vehiclebooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @Column(name = "route_id", nullable = false)
    private String routeId;

    @Column(name = "from", nullable = false)
    private String from;

    @Column(name = "arrive", nullable = false)
    private String arrive;

    @Column(name = "distance", nullable = false)
    private String distance;

    @Column(name = "image")
    private String image;

    @Column(name = "fare", nullable = false)
    private String fare;

    @Column(name = "status", nullable = false)
    private String status;
}
