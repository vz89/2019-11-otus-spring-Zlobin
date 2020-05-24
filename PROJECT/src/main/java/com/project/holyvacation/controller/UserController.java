package com.project.holyvacation.controller;


import com.project.holyvacation.domain.User;
import com.project.holyvacation.dto.UserDTO;
import com.project.holyvacation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/api/user")
    public ResponseEntity<UserDTO> getUser(Principal principal) {
        return new ResponseEntity<>(userService.getUser(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/user")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) == null) {
            userService.register(user);
            return new ResponseEntity<>(user.getUsername(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("username " + user.getUsername() + " is already used", HttpStatus.CONFLICT);
    }

    @PutMapping("/api/user")
    public ResponseEntity<String> editUser(@RequestBody UserDTO userDTO, Principal principal) {
        userService.update(userDTO, principal.getName());
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
