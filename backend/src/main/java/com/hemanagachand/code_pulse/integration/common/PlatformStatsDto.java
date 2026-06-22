package com.hemanagachand.code_pulse.integration.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlatformStatsDto {

    private Integer currentRating;

    private Integer highestRating;

    private Integer totalSolved;
}