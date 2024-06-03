package com.microservice.parking_management.microservice_parking_management.api;

import com.microservice.parking_management.microservice_parking_management.bl.ParkingBl;
import com.microservice.parking_management.microservice_parking_management.entity.ParkingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parkings")
public class ParkingApi {

    private final ParkingBl parkingBl;
    @Autowired
    public ParkingApi(ParkingBl parkingBl) {
        this.parkingBl = parkingBl;
    }


    @GetMapping
    public ResponseEntity<List<ParkingEntity>> getAllParkings() {
        List<ParkingEntity> parkings = parkingBl.findAll();
        return ResponseEntity.ok(parkings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingEntity> getParkingById(@PathVariable Long id) {
        Optional<ParkingEntity> parking = parkingBl.findById(id);
        return parking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ParkingEntity> createParking(@RequestBody ParkingEntity parking) {
        ParkingEntity savedParking = parkingBl.save(parking);
        return ResponseEntity.ok(savedParking);
    }


}


