package com.airlineapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class JWTUser {
    @Column(unique = true)
    private String username;
    private String password;
    @Id
    @GeneratedValue
    private  Integer userId;

    public JWTUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
