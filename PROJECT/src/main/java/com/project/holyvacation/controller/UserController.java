package com.project.holyvacation.controller;


import com.project.holyvacation.domain.User;
import com.project.holyvacation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) == null) {
            userService.register(user);
            return new ResponseEntity<>(user.getUsername(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("username " + user.getUsername() + " is already used", HttpStatus.CONFLICT);
    }


}
