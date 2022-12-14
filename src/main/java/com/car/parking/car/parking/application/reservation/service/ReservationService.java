package com.car.parking.car.parking.application.reservation.service;

import com.car.parking.car.parking.application.entity.ReservationEntity;
import com.car.parking.car.parking.application.reservation.dto.ReservationDto;
import com.car.parking.car.parking.application.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationEntity addReservation(ReservationDto reservationDto) {
        ReservationEntity reservationEntity = ReservationEntity
                .builder()
                .floor(reservationDto
                        .getFloor())
                .sector(reservationDto
                        .getSector())
                .build();


        return reservationRepository.save(reservationEntity);
    }

    public List<ReservationEntity> findReservationByFloor(Integer floor) {
        return reservationRepository.findReservationEntityByFloor(floor);
    }
}
