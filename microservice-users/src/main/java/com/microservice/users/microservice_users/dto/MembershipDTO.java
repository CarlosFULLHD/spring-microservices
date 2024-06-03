package com.microservice.users.microservice_users.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MembershipDTO {
    private Long id;
    private Long userId;
    private String type;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
}