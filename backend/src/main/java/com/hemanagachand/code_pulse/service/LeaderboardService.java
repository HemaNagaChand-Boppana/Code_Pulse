package com.hemanagachand.code_pulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hemanagachand.code_pulse.dto.LeaderboardResponse;
import com.hemanagachand.code_pulse.entity.User;
import com.hemanagachand.code_pulse.repository.UserRepository;

@Service
public class LeaderboardService {

    private final UserRepository userRepository;

    public LeaderboardService(
            UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<LeaderboardResponse> getLeaderboard() {

        return userRepository
                .findAllByOrderByLeaderboardScoreDesc()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private LeaderboardResponse mapToResponse(
            User user) {

        return LeaderboardResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .leaderboardScore(
                        user.getLeaderboardScore())
                .build();
    }
}