package com.example.semesterprojektbackend.registration;

import com.example.semesterprojektbackend.model.User;
import com.example.semesterprojektbackend.model.enumuration.Role;
import com.example.semesterprojektbackend.registration.token.ConfirmationToken;
import com.example.semesterprojektbackend.registration.token.ConfirmationTokenService;
import com.example.semesterprojektbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {

        String token = userService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getUsername(),
                        request.getPassword(),
                        Role.ROLE_USER
                )
        );
        System.out.println("This is TOken"+token.toString());
        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));
        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("username already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getUsername());
        return "confirmed";
    }
}
