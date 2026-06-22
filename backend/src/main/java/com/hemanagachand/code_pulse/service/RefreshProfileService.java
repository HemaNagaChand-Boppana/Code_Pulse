package com.hemanagachand.code_pulse.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hemanagachand.code_pulse.dto.RefreshProfileResponse;
import com.hemanagachand.code_pulse.entity.PlatformAccount;
import com.hemanagachand.code_pulse.entity.PlatformStats;
import com.hemanagachand.code_pulse.entity.User;
import com.hemanagachand.code_pulse.exception.InvalidPlatformUsernameException;
import com.hemanagachand.code_pulse.exception.PlatformAccountNotFoundException;
import com.hemanagachand.code_pulse.exception.UserNotFoundException;
import com.hemanagachand.code_pulse.integration.common.PlatformIntegration;
import com.hemanagachand.code_pulse.integration.common.PlatformStatsDto;
import com.hemanagachand.code_pulse.repository.PlatformAccountRepository;
import com.hemanagachand.code_pulse.repository.PlatformStatsRepository;
import com.hemanagachand.code_pulse.repository.UserRepository;

@Service
public class RefreshProfileService {

    private final UserRepository userRepository;
    private final PlatformAccountRepository platformAccountRepository;
    private final PlatformStatsRepository platformStatsRepository;
    private final List<PlatformIntegration> integrations;

    public RefreshProfileService(
            UserRepository userRepository,
            PlatformAccountRepository platformAccountRepository,
            PlatformStatsRepository platformStatsRepository,
            List<PlatformIntegration> integrations) {

        this.userRepository = userRepository;
        this.platformAccountRepository = platformAccountRepository;
        this.platformStatsRepository = platformStatsRepository;
        this.integrations = integrations;
    }

    public RefreshProfileResponse refreshProfile(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"));

        List<PlatformAccount> accounts =
                platformAccountRepository.findByUser(user);

        if (accounts.isEmpty()) {
            throw new PlatformAccountNotFoundException(
                    "No platform accounts linked to this user");
        }

        int totalScore = 0;

        for (PlatformAccount account : accounts) {

            PlatformIntegration integration =
                    integrations.stream()
                            .filter(i ->
                                    i.getPlatform()
                                            .equals(account.getPlatform()))
                            .findFirst()
                            .orElse(null);

            if (integration == null) {
                continue;
            }

            PlatformStatsDto statsDto;

            try {

                statsDto = integration.fetchStats(
                        account.getUsername());

            } catch (Exception ex) {

                throw new InvalidPlatformUsernameException(
                        "Invalid username for "
                                + account.getPlatform());
            }

            PlatformStats stats =
                    platformStatsRepository
                            .findByPlatformAccount(account)
                            .orElse(new PlatformStats());

            stats.setPlatformAccount(account);
            stats.setCurrentRating(
                    statsDto.getCurrentRating());
            stats.setHighestRating(
                    statsDto.getHighestRating());
            stats.setTotalSolved(
                    statsDto.getTotalSolved());

            platformStatsRepository.save(stats);

            totalScore +=
                    statsDto.getCurrentRating()
                            + (statsDto.getTotalSolved() * 2);
        }

        user.setLeaderboardScore(totalScore);
        user.setLastSyncedAt(LocalDateTime.now());

        userRepository.save(user);

        return RefreshProfileResponse.builder()
                .userId(user.getId())
                .leaderboardScore(user.getLeaderboardScore())
                .message("Profile refreshed successfully")
                .build();
    }
}