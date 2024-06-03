package com.microservice.parking_management.microservice_parking_management.bl;


import com.microservice.parking_management.microservice_parking_management.dao.ParkingDao;
import com.microservice.parking_management.microservice_parking_management.dao.SpotDao;
import com.microservice.parking_management.microservice_parking_management.entity.ParkingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingBl {

    private final ParkingDao parkingDao;
    private final SpotDao spotDao;
    @Autowired
    public ParkingBl(ParkingDao parkingDao, SpotDao spotDao) {
        this.parkingDao = parkingDao;
        this.spotDao = spotDao;
    }


    public List<ParkingEntity> findAll(){
        return parkingDao.findAll();
    }

    public Optional<ParkingEntity> findById(Long id){
        return parkingDao.findById(id);
    }

    public ParkingEntity save(ParkingEntity parkingEntity){
        return parkingDao.save(parkingEntity);
    }

}
