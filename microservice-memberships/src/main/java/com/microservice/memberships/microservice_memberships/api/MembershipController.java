package com.microservice.memberships.microservice_memberships.api;


import com.microservice.memberships.microservice_memberships.Entity.MembershipEntity;
import com.microservice.memberships.microservice_memberships.Entity.MembershipFeatureEntity;
import com.microservice.memberships.microservice_memberships.bl.MembershipBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    private final MembershipBl membershipBl;

    @Autowired
    public MembershipController(MembershipBl membershipBl) {
        this.membershipBl = membershipBl;
    }

    @GetMapping
    public ResponseEntity<List<MembershipEntity>> getAllMemberships() {
        List<MembershipEntity> memberships = membershipBl.findAll();
        return ResponseEntity.ok(memberships);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipEntity> getMembershipById(@PathVariable Long id) {
        Optional<MembershipEntity> membership = membershipBl.findById(id);
        return membership.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MembershipEntity> createMembership(@RequestBody MembershipEntity membership) {
        MembershipEntity savedMembership = membershipBl.save(membership);
        return ResponseEntity.ok(savedMembership);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Long id) {
        membershipBl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{membershipId}/features")
    public ResponseEntity<List<MembershipFeatureEntity>> getMembershipFeatures(@PathVariable Long membershipId) {
        List<MembershipFeatureEntity> features = membershipBl.findAllFeaturesByMembershipId(membershipId);
        return ResponseEntity.ok(features);
    }
}
