package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.User;
import com.example.semesterprojektbackend.model.UserDTO;
import com.example.semesterprojektbackend.registration.token.ConfirmationToken;
import com.example.semesterprojektbackend.registration.token.ConfirmationTokenRepo;
import com.example.semesterprojektbackend.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDTOService {
    private final UserRepo userRepo;
    ConfirmationTokenRepo confirmationTokenRepo;

    public UserDTO findByToken(String token){
        Optional<ConfirmationToken> confirmationToken = confirmationTokenRepo.findByToken(token);
        Optional<User> user = userRepo.findById(confirmationToken.get().getUser().getId());
        UserDTO userDTO = new UserDTO();
        userDTO.setEnabled(user.get().getEnabled());
        userDTO.setFirstName(user.get().getFirstName());
        userDTO.setLocked(user.get().getLocked());
        userDTO.setUsername(user.get().getUsername());
        userDTO.setLastName(user.get().getLastName());
        return userDTO;
    }
}
