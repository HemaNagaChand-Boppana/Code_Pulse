package com.hemanagachand.code_pulse.dto;

import com.hemanagachand.code_pulse.enums.Role;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private String college;

    private String branch;

    private Integer year;

    private Integer leaderboardScore;

    private Role role;
}