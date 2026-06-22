package com.hemanagachand.code_pulse.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatformStatsRequest {

    private Long platformAccountId;

    private Integer currentRating;

    private Integer highestRating;

    private Integer totalSolved;
}