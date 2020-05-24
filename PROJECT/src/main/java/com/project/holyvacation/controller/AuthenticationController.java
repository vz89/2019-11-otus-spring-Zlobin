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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping
@RequiredArgsConstructor

public class AuthenticationController {

    private static final String USERNAME = "username";
    private static final String TOKEN = "token";
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDTO requestDTO) {
        try {
            String username = requestDTO.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDTO.getPassword()));
            User user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User with username + " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());
            Map<Object, Object> response = new HashMap<>();
            response.put(USERNAME, username);
            response.put(TOKEN, token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            //throw new BadCredentialsException("Invalid username or password");
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/api/auth/check")
    public ResponseEntity<?> checkUsername(Principal principal) {
        if (principal.getName() != null) return new ResponseEntity<>(principal.getName(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


}
