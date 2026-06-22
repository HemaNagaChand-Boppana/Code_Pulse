package com.hemanagachand.code_pulse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GithubActivityResponse {

    private String date;
    private int count;
}