package com.microservice.parking_management.microservice_parking_management.dao;

import com.microservice.parking_management.microservice_parking_management.entity.SpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotDao extends JpaRepository<SpotEntity,Long> {

}
