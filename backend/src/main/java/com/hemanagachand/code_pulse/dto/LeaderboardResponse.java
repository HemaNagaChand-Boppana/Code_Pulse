package com.hemanagachand.code_pulse.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LeaderboardResponse {

    private Long userId;

    private String name;

    private Integer leaderboardScore;
}