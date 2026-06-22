package com.hemanagachand.code_pulse.integration.codeforces.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeforcesUser {

    private String handle;

    private Integer rating;

    private Integer maxRating;
}