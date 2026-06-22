package com.hemanagachand.code_pulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hemanagachand.code_pulse.dto.ProfilePlatformResponse;
import com.hemanagachand.code_pulse.dto.ProfileResponse;
import com.hemanagachand.code_pulse.entity.PlatformAccount;
import com.hemanagachand.code_pulse.entity.PlatformStats;
import com.hemanagachand.code_pulse.entity.User;
import com.hemanagachand.code_pulse.exception.UserNotFoundException;
import com.hemanagachand.code_pulse.repository.PlatformAccountRepository;
import com.hemanagachand.code_pulse.repository.PlatformStatsRepository;
import com.hemanagachand.code_pulse.repository.UserRepository;

@Service
public class ProfileService {

    private final UserRepository userRepository;
    private final PlatformAccountRepository platformAccountRepository;
    private final PlatformStatsRepository platformStatsRepository;

    public ProfileService(
            UserRepository userRepository,
            PlatformAccountRepository platformAccountRepository,
            PlatformStatsRepository platformStatsRepository) {

        this.userRepository = userRepository;
        this.platformAccountRepository = platformAccountRepository;
        this.platformStatsRepository = platformStatsRepository;
    }

    public ProfileResponse getProfile(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"));

        List<PlatformAccount> accounts =
                platformAccountRepository.findByUser(user);

        List<ProfilePlatformResponse> platforms =
                accounts.stream()
                        .map(this::mapPlatform)
                        .toList();

        return ProfileResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .college(user.getCollege())
                .branch(user.getBranch())
                .year(user.getYear())
                .leaderboardScore(
                        user.getLeaderboardScore())
                .platforms(platforms)
                .build();
    }

    private ProfilePlatformResponse mapPlatform(
            PlatformAccount account) {

        PlatformStats stats =
                platformStatsRepository
                        .findByPlatformAccount(account)
                        .orElse(null);

        return ProfilePlatformResponse.builder()
                .platform(account.getPlatform())
                .username(account.getUsername())
                .currentRating(
                        stats != null
                                ? stats.getCurrentRating()
                                : 0)
                .highestRating(
                        stats != null
                                ? stats.getHighestRating()
                                : 0)
                .totalSolved(
                        stats != null
                                ? stats.getTotalSolved()
                                : 0)
                .build();
    }
}