package com.hemanagachand.code_pulse.integration.github;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hemanagachand.code_pulse.integration.github.dto.GitHubUserResponse;

@Service
public class GitHubService {

    private final RestTemplate restTemplate;

    public GitHubService() {
        this.restTemplate = new RestTemplate();
    }

    public GitHubUserResponse getUserProfile(
            String username) {

        String url =
                "https://api.github.com/users/"
                        + username;

        ResponseEntity<GitHubUserResponse> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        });

        return response.getBody();
    }
}