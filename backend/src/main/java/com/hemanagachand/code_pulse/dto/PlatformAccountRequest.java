package com.hemanagachand.code_pulse.dto;

import com.hemanagachand.code_pulse.enums.Platform;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatformAccountRequest {

    private Long userId;

    private Platform platform;

    private String username;
}