package com.example.semesterprojektbackend.security.dto;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final String ERROR_MESSAGE = "";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String requestBody;
        try {
            requestBody = request.getReader().lines().collect(Collectors.joining());
            System.out.println("This is the request Body"+requestBody);
            ObjectMapper objectMapper = new ObjectMapper();
            LoginRequest loginRequest = objectMapper.readValue(requestBody, LoginRequest.class);
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password);
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new InternalAuthenticationServiceException("ERROR_MESSAGE", e);
        }
    }
}
