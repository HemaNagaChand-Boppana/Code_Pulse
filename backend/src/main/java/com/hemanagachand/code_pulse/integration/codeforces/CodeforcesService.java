package com.hemanagachand.code_pulse.integration.codeforces;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hemanagachand.code_pulse.integration.codeforces.dto.CodeforcesResponse;

@Service
public class CodeforcesService {

    private final RestTemplate restTemplate;

    public CodeforcesService() {
        this.restTemplate = new RestTemplate();
    }

    public CodeforcesResponse getUserInfo(String username) {

        String url =
                "https://codeforces.com/api/user.info?handles="
                        + username;

        return restTemplate.getForObject(
                url,
                CodeforcesResponse.class
        );
    }
}