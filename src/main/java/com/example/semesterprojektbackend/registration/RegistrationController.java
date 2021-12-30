package com.example.semesterprojektbackend.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(path = "/registration")
@AllArgsConstructor
@RestController
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@Valid RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
