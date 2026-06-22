package com.hemanagachand.code_pulse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hemanagachand.code_pulse.dto.GithubActivityResponse;

@Service
public class GithubActivityService {

    private final RestTemplate restTemplate =
            new RestTemplate();

    @SuppressWarnings("unchecked")
    public List<GithubActivityResponse> getActivity(
            String username) {

        String url =
                "https://api.github.com/users/"
                        + username
                        + "/events/public";

        List<Map<String, Object>> events =
                restTemplate.getForObject(
                        url,
                        List.class
                );

        Map<String, Integer> activityMap =
                new HashMap<>();

        if (events == null) {
            return new ArrayList<>();
        }

        for (Map<String, Object> event : events) {

            String type =
                    (String) event.get("type");

            boolean supportedEvent =
                    "PushEvent".equals(type)
                    || "CreateEvent".equals(type)
                    || "PullRequestEvent".equals(type)
                    || "IssuesEvent".equals(type)
                    || "IssueCommentEvent".equals(type)
                    || "PullRequestReviewEvent".equals(type);

            if (!supportedEvent) {
                continue;
            }

            String createdAt =
                    (String) event.get("created_at");

            String date =
                    createdAt.substring(0, 10);

            activityMap.put(
                    date,
                    activityMap.getOrDefault(
                            date,
                            0
                    ) + 1
            );
        }

        List<GithubActivityResponse> result =
                new ArrayList<>();

        activityMap.forEach(
                (date, count) ->
                        result.add(
                                new GithubActivityResponse(
                                        date,
                                        count
                                )
                        )
        );

        return result;
    }
}