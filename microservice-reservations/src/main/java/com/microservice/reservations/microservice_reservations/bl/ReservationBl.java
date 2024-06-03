package com.microservice.reservations.microservice_reservations.bl;


import com.microservice.reservations.microservice_reservations.dao.ReservationRepository;
import com.microservice.reservations.microservice_reservations.entity.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationBl {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationBl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationEntity> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<ReservationEntity> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public ReservationEntity save(ReservationEntity reservationEntity) {
        return reservationRepository.save(reservationEntity);
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
