package com.example.demo.controllers.dto;

import com.example.demo.services.models.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
public class UserDto {
    @Id
    @GeneratedValue
    private int id;
    @Builder.Default()
    private String lastname = null;
    @Builder.Default()
    private String firstname = null;
    @Builder.Default()
    private String email = null;
    @Builder.Default()
    private String password = null;
    @Builder.Default()
    private String phoneNumber = null;
    @Builder.Default()
    private boolean cguSigned = false;
    @Builder.Default()
    private String csrfToken = null;

    public User toUser(){
        return new User(this.id, this.lastname, this.firstname, this.email, this.password, this.phoneNumber, false, false, this.cguSigned, this.csrfToken);
    }
}
