package com.microservice.memberships.microservice_memberships.dao;

import com.microservice.memberships.microservice_memberships.Entity.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<MembershipEntity,Long> {
    List<MembershipEntity> findByUserId(Long userId);
}
