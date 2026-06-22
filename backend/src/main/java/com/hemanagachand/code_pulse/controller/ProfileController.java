package com.hemanagachand.code_pulse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemanagachand.code_pulse.dto.ProfileResponse;
import com.hemanagachand.code_pulse.dto.RefreshProfileResponse;
import com.hemanagachand.code_pulse.service.ProfileService;
import com.hemanagachand.code_pulse.service.RefreshProfileService;

@RestController
public class ProfileController {

    private final RefreshProfileService refreshProfileService;
    private final ProfileService profileService;

    public ProfileController(
            RefreshProfileService refreshProfileService,
            ProfileService profileService) {

        this.refreshProfileService = refreshProfileService;
        this.profileService = profileService;
    }

    @PostMapping("/api/profile/refresh/{userId}")
    public RefreshProfileResponse refreshProfile(
            @PathVariable Long userId) {

        return refreshProfileService.refreshProfile(userId);
    }

    @GetMapping("/api/profile/{userId}")
    public ProfileResponse getProfile(
            @PathVariable Long userId) {

        return profileService.getProfile(userId);
    }
}