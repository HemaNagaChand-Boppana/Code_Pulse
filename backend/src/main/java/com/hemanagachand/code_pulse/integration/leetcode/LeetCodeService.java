package com.hemanagachand.code_pulse.integration.leetcode;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LeetCodeService {

    private final RestTemplate restTemplate;

    public LeetCodeService() {
        this.restTemplate = new RestTemplate();
    }

    public String getUserProfile(String username) {

        String url = "https://leetcode.com/graphql";

        String query = """
            query getUserProfile($username: String!) {
              matchedUser(username: $username) {
                submitStats {
                  acSubmissionNum {
                    difficulty
                    count
                  }
                }
              }
            }
            """;

        Map<String, Object> variables =
                Map.of("username", username);

        Map<String, Object> requestBody =
                Map.of(
                        "query", query,
                        "variables", variables
                );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(requestBody, headers);

        return restTemplate.postForObject(
                url,
                entity,
                String.class
        );
    }
}