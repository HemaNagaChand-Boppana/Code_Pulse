package com.hemanagachand.code_pulse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hemanagachand.code_pulse.integration.codeforces.CodeforcesService;
import com.hemanagachand.code_pulse.integration.codeforces.dto.CodeforcesResponse;

@RestController
public class TestController {

    private final CodeforcesService codeforcesService;

    public TestController(CodeforcesService codeforcesService) {
        this.codeforcesService = codeforcesService;
    }

    @GetMapping("/api/test/codeforces/{username}")
    public CodeforcesResponse getCodeforcesUser(
            @PathVariable String username) {

        return codeforcesService.getUserInfo(username);
    }
}