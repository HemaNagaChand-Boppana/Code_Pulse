package com.hemanagachand.code_pulse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hemanagachand.code_pulse.dto.GithubActivityResponse;
import com.hemanagachand.code_pulse.service.GithubActivityService;

@RestController
@RequestMapping("/api/github")
public class GithubActivityController {

    private final GithubActivityService githubActivityService;

    public GithubActivityController(
            GithubActivityService githubActivityService) {

        this.githubActivityService =
                githubActivityService;
    }

    @GetMapping("/activity/{username}")
    public List<GithubActivityResponse> getActivity(
            @PathVariable String username) {

        return githubActivityService
                .getActivity(username);
    }
}