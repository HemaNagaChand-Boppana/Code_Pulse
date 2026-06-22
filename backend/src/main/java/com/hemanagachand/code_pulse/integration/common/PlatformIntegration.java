package com.hemanagachand.code_pulse.integration.common;

import com.hemanagachand.code_pulse.enums.Platform;

public interface PlatformIntegration {

    Platform getPlatform();

    PlatformStatsDto fetchStats(String username);
}