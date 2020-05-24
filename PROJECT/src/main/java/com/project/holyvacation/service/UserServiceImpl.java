package com.project.holyvacation.service;

import com.project.holyvacation.domain.Role;
import com.project.holyvacation.domain.Status;
import com.project.holyvacation.domain.User;
import com.project.holyvacation.dto.UserDTO;
import com.project.holyvacation.dto.mapper.UserMapper;
import com.project.holyvacation.repo.RoleRepo;
import com.project.holyvacation.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public User register(User user) {
        Role roleUser = roleRepo.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        user.setStatus(Status.ACTIVE);
        user.setCreatedDate(LocalDate.now());
        return userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByUsername(String username)
    {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findById(Long id) {

        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(UserDTO userDTO, String name) {
        userRepo.save(userMapper.updateEntity(userDTO,userRepo.findByUsername(name)));
    }

    @Override
    public UserDTO getUser(String name) {
        return userMapper.toDTO(userRepo.findByUsername(name));
    }
}
