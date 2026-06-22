package com.hemanagachand.code_pulse.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlatformStatsResponse {

    private Long id;

    private Long platformAccountId;

    private Integer currentRating;

    private Integer highestRating;

    private Integer totalSolved;
}