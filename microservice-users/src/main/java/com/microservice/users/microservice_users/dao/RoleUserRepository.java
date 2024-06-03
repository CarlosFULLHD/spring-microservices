package com.microservice.users.microservice_users.dao;


import com.microservice.users.microservice_users.entity.RoleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUserEntity, Long> {
}
