package com.microservice.users.microservice_users.dao;

import com.microservice.users.microservice_users.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findAllByUserId(Long userId);
}