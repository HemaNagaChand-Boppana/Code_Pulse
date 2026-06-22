package com.hemanagachand.code_pulse.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String name;
    private String email;
    private String college;
    private String branch;
    private Integer year;
}