package com.car.parking.car.parking.application.reservation.repository;

import com.car.parking.car.parking.application.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findReservationEntityByFloor(Integer floor);
    List<ReservationEntity> findReservationEntityByFloorAndSector(Integer floor, String sector);
    void deleteReservationEntityById(Long id);

    ReservationEntity findReservationEntityById(Long id);
}
