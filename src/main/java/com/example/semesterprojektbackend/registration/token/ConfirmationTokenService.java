package com.example.semesterprojektbackend.registration.token;

import com.example.semesterprojektbackend.model.User;
import com.example.semesterprojektbackend.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepo confirmationTokenRepo;
private final UserRepo userRepo;
    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepo.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepo.findByToken(token);
    }
    public TokenDTO getTokenByUserId(Long id) {
        Optional<ConfirmationToken> confirmationToken = confirmationTokenRepo.findByUserId(id);
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(confirmationToken.get().getToken());
        return tokenDTO;
    }

    public TokenDTO getTokenByUsername(String username) {
        Optional<User> loggedInUser = userRepo.findByUsername(username);
        Optional<ConfirmationToken> confirmationToken = confirmationTokenRepo.findByUserId(loggedInUser.get().getId());
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(confirmationToken.get().getToken());
        tokenDTO.setRole(loggedInUser.get().getRole().toString());
        return tokenDTO;
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
