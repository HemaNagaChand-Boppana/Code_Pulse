package com.hemanagachand.code_pulse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hemanagachand.code_pulse.dto.PlatformAccountRequest;
import com.hemanagachand.code_pulse.dto.PlatformAccountResponse;
import com.hemanagachand.code_pulse.dto.PlatformAccountUpdateRequest;
import com.hemanagachand.code_pulse.service.PlatformAccountService;

@RestController
@RequestMapping("/api/platform-accounts")
public class PlatformAccountController {

    private final PlatformAccountService platformAccountService;

    public PlatformAccountController(
            PlatformAccountService platformAccountService) {

        this.platformAccountService = platformAccountService;
    }

    @PostMapping
    public PlatformAccountResponse createPlatformAccount(
            @RequestBody PlatformAccountRequest request) {

        return platformAccountService
                .createPlatformAccount(request);
    }

    @GetMapping("/user/{userId}")
    public List<PlatformAccountResponse> getAccountsByUserId(
            @PathVariable Long userId) {

        return platformAccountService
                .getAccountsByUserId(userId);
    }

    @PutMapping("/{accountId}")
    public PlatformAccountResponse updatePlatformAccount(
            @PathVariable Long accountId,
            @RequestBody PlatformAccountUpdateRequest request) {

        return platformAccountService
                .updatePlatformAccount(
                        accountId,
                        request);
    }
}