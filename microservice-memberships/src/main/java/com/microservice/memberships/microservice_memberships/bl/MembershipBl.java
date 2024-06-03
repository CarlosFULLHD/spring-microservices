package com.microservice.memberships.microservice_memberships.bl;


import com.microservice.memberships.microservice_memberships.Entity.MembershipEntity;
import com.microservice.memberships.microservice_memberships.Entity.MembershipFeatureEntity;
import com.microservice.memberships.microservice_memberships.dao.MembershipFeatureRepository;
import com.microservice.memberships.microservice_memberships.dao.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipBl {

    private final MembershipRepository membershipRepository;
    private final MembershipFeatureRepository membershipFeatureRepository;

    @Autowired
    public MembershipBl(MembershipRepository membershipRepository, MembershipFeatureRepository membershipFeatureRepository) {
        this.membershipRepository = membershipRepository;
        this.membershipFeatureRepository = membershipFeatureRepository;
    }

    public List<MembershipEntity> findAll() {
        return membershipRepository.findAll();
    }

    public Optional<MembershipEntity> findById(Long id) {
        return membershipRepository.findById(id);
    }

    public MembershipEntity save(MembershipEntity membershipEntity) {
        return membershipRepository.save(membershipEntity);
    }

    public void deleteById(Long id) {
        membershipRepository.deleteById(id);
    }

    public List<MembershipFeatureEntity> findAllFeaturesByMembershipId(Long membershipId) {
        return membershipFeatureRepository.findAllByMembershipId(membershipId);
    }
    public List<MembershipEntity> findByUserId(Long userId) {
        return membershipRepository.findByUserId(userId);
    }
}
