package com.example.demo.services.models;

import com.example.demo.controllers.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;
import org.apache.el.parser.Token;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class User {
    @Builder.Default()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id = 0;
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
    private boolean emailValidated = false;
    @Builder.Default()
    private boolean phoneNumberValidated = false;
    @Builder.Default()
    private boolean cguSigned = false;
    @Builder.Default()
    private String csrfToken = null;

    public UserDto toUserDto(){
        return new UserDto(this.id, this.lastname, this.firstname, this.email, this.password, this.phoneNumber, this.cguSigned, this.csrfToken);
    }
}
