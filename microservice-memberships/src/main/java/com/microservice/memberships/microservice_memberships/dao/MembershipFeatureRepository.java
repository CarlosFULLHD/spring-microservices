package com.microservice.memberships.microservice_memberships.dao;

import com.microservice.memberships.microservice_memberships.Entity.MembershipFeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipFeatureRepository extends JpaRepository<MembershipFeatureEntity, Long> {
    List<MembershipFeatureEntity> findAllByMembershipId(Long membershipId);
}