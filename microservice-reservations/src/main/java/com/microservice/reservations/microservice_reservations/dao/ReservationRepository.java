package com.microservice.reservations.microservice_reservations.dao;

import com.microservice.reservations.microservice_reservations.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

}
