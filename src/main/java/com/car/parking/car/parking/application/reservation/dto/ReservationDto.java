package com.car.parking.car.parking.application.reservation.dto;

import com.car.parking.car.parking.application.reservation.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class ReservationDto {
    Long id;
    StatusEnum status;
}
