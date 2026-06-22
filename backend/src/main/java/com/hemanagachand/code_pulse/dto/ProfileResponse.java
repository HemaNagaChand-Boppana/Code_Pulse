package com.hemanagachand.code_pulse.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfileResponse {

    private Long userId;

    private String name;

    private String email;

    private String college;

    private String branch;

    private Integer year;

    private Integer leaderboardScore;

    private List<ProfilePlatformResponse> platforms;
}