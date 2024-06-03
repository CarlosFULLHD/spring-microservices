package com.microservice.users.microservice_users.client;



import com.microservice.users.microservice_users.dto.MembershipDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-memberships", url = "http://localhost:8084")
public interface UserMembershipClient {
    @GetMapping("/api/memberships/user/{userId}")
    List<MembershipDTO> getMembershipsByUserId(@PathVariable("userId") Long userId);
}
