package com.example.semesterprojektbackend.security;

import com.example.semesterprojektbackend.security.dto.LoginRequest;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String requestBody;
        try {
            requestBody = request.getReader().lines().collect(Collectors.joining());
            ObjectMapper objectMapper = new JsonMapper();
            LoginRequest loginRequest = objectMapper.readValue(requestBody, LoginRequest.class);
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password);
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new InternalAuthenticationServiceException("ERROR_MESSAGE", e);
        }
    }
}


/*
public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private String ERROR_MESSAGE = "";
/*
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String requestBody;
        try {
            requestBody = request.getReader().lines().collect(Collectors.joining());
            ObjectMapper objectMapper=new ObjectMapper();
            LoginRequest loginRequest = objectMapper.readValue(requestBody, LoginRequest.class);
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password);
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new InternalAuthenticationServiceException(ERROR_MESSAGE, e);
        }
    }*/
//}*/