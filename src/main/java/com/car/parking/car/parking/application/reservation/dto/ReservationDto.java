package com.car.parking.car.parking.application.reservation.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReservationDto {
    Integer floor;
    String sector;
}
