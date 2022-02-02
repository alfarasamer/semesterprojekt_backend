package com.example.semesterprojektbackend.registration.token;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/token")
@AllArgsConstructor
@RestController
public class ConfirmationTokenController {

    private final ConfirmationTokenService confirmationTokenService;
    @GetMapping("/{username}")
    @JsonIgnore
    public TokenDTO getTokenByUsername(@PathVariable String username) {
        return confirmationTokenService.getTokenByUsername(username);
    }


}