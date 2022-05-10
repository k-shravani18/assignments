package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "flightUser")
public class AppUser {
    @Column(unique = true,length = 20)
    private String username;
    private String password;
    @Id
    @GeneratedValue
    private  Integer userId;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
