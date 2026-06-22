package com.hemanagachand.code_pulse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hemanagachand.code_pulse.integration.leetcode.LeetCodeService;

@RestController
public class LeetCodeTestController {

    private final LeetCodeService leetCodeService;

    public LeetCodeTestController(
            LeetCodeService leetCodeService) {

        this.leetCodeService = leetCodeService;
    }

    @GetMapping("/api/test/leetcode/{username}")
    public String testLeetCode(
            @PathVariable String username) {

        return leetCodeService.getUserProfile(
                username);
    }
}