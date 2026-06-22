package com.hemanagachand.code_pulse.dto;

import com.hemanagachand.code_pulse.enums.Platform;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PlatformAccountResponse {

    private Long id;

    private Long userId;

    private Platform platform;

    private String username;
}