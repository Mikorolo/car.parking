package com.car.parking.car.parking.application.reservation.client;

import com.car.parking.car.parking.application.entity.ReservationEntity;
import com.car.parking.car.parking.application.reservation.dto.ReservationDto;
import com.car.parking.car.parking.application.reservation.repository.ReservationRepository;
import com.car.parking.car.parking.application.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/GetReservations")
    public List<ReservationEntity> findReservationByFloor(@RequestParam Integer floor) {
        return reservationService.findReservationByFloor(floor);
    }

    @PostMapping("/addReservation")
    public ReservationEntity addReservation(@RequestBody ReservationDto reservationDto) {
        return reservationService.addReservation(reservationDto);
    }
}
