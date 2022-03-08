package com.example.semesterprojektbackend.service;

import com.example.semesterprojektbackend.model.User;
import com.example.semesterprojektbackend.model.enumuration.Role;
import com.example.semesterprojektbackend.registration.token.ConfirmationToken;
import com.example.semesterprojektbackend.registration.token.ConfirmationTokenService;
import com.example.semesterprojektbackend.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with username %s not found";

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final CartService CartService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, username)));
    }

    public String signUpUser(User user) {
        boolean userExists = userRepo
                .findByUsername(user.getUsername())
                .isPresent();
        if (userExists) {
            throw new IllegalStateException(": username already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());

        user.setPassword(encodedPassword);
        System.out.println("User Service"+user.toString());
        user.setRole(Role.ROLE_USER);
        userRepo.save(user);
        /*Optional<User> signedUpUser = userRepo.findByUsername(user.getUsername());
        System.out.println("Registered User" + signedUpUser.toString());
        user.setCart(CartService.createCart(signedUpUser.get().getId()));*/

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);
        return token;
    }

    public int enableUser(String username) {
        return userRepo.enableUser(username);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public User save(User user) {
        userRepo.save(user);
        return user;
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public User updateUser(Long id,User userDetails){

        boolean userExists = userRepo
                .findByUsername(userDetails.getUsername())
                .isPresent();
        if (!userExists) {
            throw new IllegalStateException("User with Id " + id + " doesn't exist");
        }

        Optional<User> user = findById(id);

        user.get().setFirstName(userDetails.getFirstName());
        user.get().setLastName(userDetails.getLastName());

        user.get().setEnabled(userDetails.getEnabled());
        user.get().setLocked(userDetails.getLocked());
        user.get().setRole(userDetails.getRole());

        User updatedUser = user.get();
        userRepo.save(updatedUser);

        return updatedUser;
    }

    public User updateUserPassword(Long id,User userDetails){

        boolean userExists = userRepo
                .findByUsername(userDetails.getUsername())
                .isPresent();
        if (!userExists) {
            throw new IllegalStateException("User with Id " + id + " doesn't exist");
        }

        Optional<User> user = findById(id);

        String encodedPassword = bCryptPasswordEncoder
                .encode(userDetails.getPassword());

        user.get().setPassword(encodedPassword);

        User updatedUserPassword = user.get();
        userRepo.save(updatedUserPassword);

        return updatedUserPassword;
    }

}
