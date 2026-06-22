package com.hemanagachand.code_pulse.integration.leetcode;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemanagachand.code_pulse.enums.Platform;
import com.hemanagachand.code_pulse.integration.common.PlatformIntegration;
import com.hemanagachand.code_pulse.integration.common.PlatformStatsDto;

@Service
public class LeetCodeIntegration implements PlatformIntegration {

    private final LeetCodeService leetCodeService;

    public LeetCodeIntegration(
            LeetCodeService leetCodeService) {

        this.leetCodeService = leetCodeService;
    }

    @Override
    public Platform getPlatform() {
        return Platform.LEETCODE;
    }

    @Override
    public PlatformStatsDto fetchStats(
            String username) {

        try {

            String response =
                    leetCodeService.getUserProfile(
                            username);

            ObjectMapper mapper =
                    new ObjectMapper();

            JsonNode root =
                    mapper.readTree(response);

            JsonNode submissions =
                    root.path("data")
                        .path("matchedUser")
                        .path("submitStats")
                        .path("acSubmissionNum");

            int totalSolved = 0;

            for (JsonNode node : submissions) {

                if ("All".equals(
                        node.get("difficulty")
                                .asText())) {

                    totalSolved =
                            node.get("count")
                                .asInt();

                    break;
                }
            }

            return new PlatformStatsDto(
                    0,
                    0,
                    totalSolved
            );

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Invalid LeetCode username");
        }
    }
}