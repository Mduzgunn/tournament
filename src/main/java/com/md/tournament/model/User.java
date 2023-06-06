package com.md.tournament.model;

import com.md.tournament.enums.UserRole;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private int age;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne
    private Team managedTeam;

    public User(String username, String password, UserRole role, int age) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.age = age;
    }

    public User(Long id, String username, String password, UserRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
