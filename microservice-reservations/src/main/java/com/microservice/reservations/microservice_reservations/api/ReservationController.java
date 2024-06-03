package com.microservice.reservations.microservice_reservations.api;


import com.microservice.reservations.microservice_reservations.bl.ReservationBl;
import com.microservice.reservations.microservice_reservations.entity.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationBl reservationBl;

    @Autowired
    public ReservationController(ReservationBl reservationBl) {
        this.reservationBl = reservationBl;
    }
    @GetMapping
    public ResponseEntity<List<ReservationEntity>> getAllReservations() {
        List<ReservationEntity> reservations = reservationBl.findAll();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationEntity> getReservationById(@PathVariable Long id) {
        Optional<ReservationEntity> reservation = reservationBl.findById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationEntity reservation) {
        ReservationEntity savedReservation = reservationBl.save(reservation);
        return ResponseEntity.ok(savedReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationBl.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}