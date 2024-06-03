package com.microservice.users.microservice_users.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
