package com.md.tournament.dto;

import com.md.tournament.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private int age;
    private UserRole role;

}
