package com.hemanagachand.code_pulse.integration.codeforces;

import org.springframework.stereotype.Service;

import com.hemanagachand.code_pulse.enums.Platform;
import com.hemanagachand.code_pulse.integration.codeforces.dto.CodeforcesResponse;
import com.hemanagachand.code_pulse.integration.codeforces.dto.CodeforcesUser;
import com.hemanagachand.code_pulse.integration.common.PlatformIntegration;
import com.hemanagachand.code_pulse.integration.common.PlatformStatsDto;

@Service
public class CodeforcesIntegration
        implements PlatformIntegration {

    private final CodeforcesService codeforcesService;

    public CodeforcesIntegration(
            CodeforcesService codeforcesService) {

        this.codeforcesService = codeforcesService;
    }

    @Override
    public Platform getPlatform() {
        return Platform.CODEFORCES;
    }

    @Override
    public PlatformStatsDto fetchStats(
            String username) {

        CodeforcesResponse response =
                codeforcesService.getUserInfo(
                        username);

        CodeforcesUser user =
                response.getResult().get(0);

        return new PlatformStatsDto(
                user.getRating(),
                user.getMaxRating(),
                0
        );
    }
}