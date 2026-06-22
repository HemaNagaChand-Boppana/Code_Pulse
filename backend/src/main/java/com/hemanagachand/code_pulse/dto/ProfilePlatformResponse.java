package com.hemanagachand.code_pulse.dto;

import com.hemanagachand.code_pulse.enums.Platform;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfilePlatformResponse {

    private Platform platform;

    private String username;

    private Integer currentRating;

    private Integer highestRating;

    private Integer totalSolved;
}