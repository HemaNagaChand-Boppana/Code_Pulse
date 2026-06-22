package com.hemanagachand.code_pulse.integration.codeforces.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeforcesResponse {

    private String status;

    private List<CodeforcesUser> result;
}