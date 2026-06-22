package com.hemanagachand.code_pulse.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RefreshProfileResponse {

    private Long userId;

    private Integer leaderboardScore;

    private String message;
}