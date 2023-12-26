package com.memorystudio.member.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String userId;
    private String password;
}
