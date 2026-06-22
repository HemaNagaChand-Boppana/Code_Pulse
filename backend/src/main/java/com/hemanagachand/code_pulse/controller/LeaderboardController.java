package com.hemanagachand.code_pulse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemanagachand.code_pulse.dto.LeaderboardResponse;
import com.hemanagachand.code_pulse.service.LeaderboardService;

@RestController
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    public LeaderboardController(
            LeaderboardService leaderboardService) {

        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/api/leaderboard")
    public List<LeaderboardResponse> getLeaderboard() {

        return leaderboardService.getLeaderboard();
    }
}