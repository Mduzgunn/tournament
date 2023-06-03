package com.md.tournament.dto.requests;

import com.md.tournament.enums.UserRole;
import lombok.Data;

@Data
public class UserUpdateRequest {
    private Long id;
    private String password;
    private UserRole role;
}
