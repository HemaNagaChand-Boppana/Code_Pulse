package com.hemanagachand.code_pulse.integration.github;

import org.springframework.stereotype.Service;

import com.hemanagachand.code_pulse.enums.Platform;
import com.hemanagachand.code_pulse.integration.common.PlatformIntegration;
import com.hemanagachand.code_pulse.integration.common.PlatformStatsDto;
import com.hemanagachand.code_pulse.integration.github.dto.GitHubUserResponse;

@Service
public class GitHubIntegration
        implements PlatformIntegration {

    private final GitHubService gitHubService;

    public GitHubIntegration(
            GitHubService gitHubService) {

        this.gitHubService = gitHubService;
    }

    @Override
    public Platform getPlatform() {
        return Platform.GITHUB;
    }

    @Override
    public PlatformStatsDto fetchStats(
            String username) {

        GitHubUserResponse user =
                gitHubService.getUserProfile(
                        username);

        return new PlatformStatsDto(
                0,
                0,
                user.getPublicRepos()
        );
    }
}