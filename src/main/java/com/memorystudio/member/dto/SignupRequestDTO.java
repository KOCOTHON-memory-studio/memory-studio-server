package com.memorystudio.member.dto;

import lombok.Data;

@Data
public class SignupRequestDTO {
    private String name;
    private String userId;
    private String email;
    private String password1;
    private String password2;
}
