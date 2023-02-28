package com.example.demo.controllers.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
public class UserValidDto {
    @Builder.Default()
    private boolean phoneNumber = false;
    @Builder.Default()
    private boolean emailValidated = false;
}
