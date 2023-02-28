package com.example.demo.controllers.feigns.models.userReponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Name {
    private String givenName;
    private String familyName;
}
