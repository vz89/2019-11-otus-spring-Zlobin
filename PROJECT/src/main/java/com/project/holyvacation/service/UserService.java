package com.project.holyvacation.service;

import com.project.holyvacation.domain.User;
import com.project.holyvacation.dto.UserDTO;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

    void update(UserDTO userDTO, String name);

    UserDTO getUser(String name);
}
