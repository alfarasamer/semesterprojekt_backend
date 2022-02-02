package com.example.semesterprojektbackend.model;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDTO {
    private String firstName;
    private String lastName;
    private String username;
    private Boolean locked;
    private Boolean enabled;
}
