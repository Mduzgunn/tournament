package com.md.tournament.dto;

import com.md.tournament.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private UserRole role;
    private List<TeamDTO> teams;
}
