package com.microservice.reservations.microservice_reservations.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long id;

    @Column(name = "users_id", nullable = false)
    private Long userId;

    @Column(name = "vehicles_id", nullable = false)
    private Long vehicleId;

    @Column(name = "spots_id", nullable = false)
    private Long spotId;

    @Column(name = "scheduled_entry", nullable = false)
    private LocalDateTime scheduledEntry;

    @Column(name = "scheduled_exit", nullable = false)
    private LocalDateTime scheduledExit;

    @Column(name = "actual_entry")
    private LocalDateTime actualEntry;

    @Column(name = "actual_exit")
    private LocalDateTime actualExit;

    @Column(nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
