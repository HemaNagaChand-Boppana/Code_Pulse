package com.hemanagachand.code_pulse.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "platform_stats")
@Getter
@Setter
public class PlatformStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "platform_account_id")
    private PlatformAccount platformAccount;

    private Integer currentRating;

    private Integer highestRating;

    private Integer totalSolved;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}