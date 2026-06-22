package com.hemanagachand.code_pulse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanagachand.code_pulse.entity.PlatformAccount;
import com.hemanagachand.code_pulse.entity.PlatformStats;

public interface PlatformStatsRepository
        extends JpaRepository<PlatformStats, Long> {

    Optional<PlatformStats> findByPlatformAccount(
            PlatformAccount platformAccount);

}