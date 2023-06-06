package com.md.tournament.dto.requests;

import com.md.tournament.enums.UserRole;
import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String password;
    private String email;
    private UserRole role;
    private int age;
}
