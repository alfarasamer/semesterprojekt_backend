package com.example.semesterprojektbackend.controller;

import com.example.semesterprojektbackend.model.UserRegistration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Registration;

@RestController
public class UserRegistrationController {
    @GetMapping("/registration")
    public UserRegistration getRegistration() {
        return getDemoRegistration();
    }

    @GetMapping("/registration/{userId}")
    public UserRegistration getRegistrationPath(@PathVariable int userId) {
        return getDemoRegistration();
    }

    private UserRegistration getDemoRegistration() {
        return new UserRegistration(1,"Max", "Mustermann", "muster@qq.com", "musteruser", "passwordtest");
    }
    @PostMapping("/registration")
    public Registration postRegistration(){return postRegistration()}
    @PostMapping("/registration/{userId}")
    public UserRegistration postRegistrationPath(@PathVariable int userId){return postDemoRegistration();}
    private UserRegistration postDemoRegistration(){
        return new UserRegistration(1,"Maxpost","Mustermanpost","mustermail@muster.com","musteruserpost","musterpasswordpost")
    }
}

