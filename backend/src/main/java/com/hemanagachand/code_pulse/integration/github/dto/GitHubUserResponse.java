    package com.hemanagachand.code_pulse.integration.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GitHubUserResponse {

    private String login;

    @JsonProperty("public_repos")
    private Integer publicRepos;

    private Integer followers;

    private Integer following;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("html_url")
    private String profileUrl;

    @JsonProperty("created_at")
    private String createdAt;
}