package com.project.holyvacation.controller;


import com.project.holyvacation.domain.User;
import com.project.holyvacation.dto.AuthenticationRequestDTO;
import com.project.holyvacation.security.jwt.JwtTokenProvider;
import com.project.holyvacation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/auth/")
@RequiredArgsConstructor
public class AuthenticationController {

    private static final String USERNAME = "username";
    private static final String TOKEN = "token";
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDTO requestDTO) {
        try {
            String username = requestDTO.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDTO.getPassword()));
            User user = userService.findByUsername(username);
            if (user == null ) {
                throw new UsernameNotFoundException("User with username + " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());
            Map<Object, Object> response = new HashMap<>();
            response.put(USERNAME, username);
            response.put(TOKEN, token);
            return ResponseEntity.ok(response);
        }
        catch (AuthenticationException e){
            //throw new BadCredentialsException("Invalid username or password");
            return new ResponseEntity("Invalid username or password",HttpStatus.UNAUTHORIZED);
        }
    }

}
