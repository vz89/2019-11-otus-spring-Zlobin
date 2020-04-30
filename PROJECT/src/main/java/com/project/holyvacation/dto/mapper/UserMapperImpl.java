package com.project.holyvacation.dto.mapper;

import com.project.holyvacation.domain.User;
import com.project.holyvacation.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO toDTO(User user) {

        return new UserDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return null;
    }
    @Override
    public User updateEntity(UserDTO userDTO, User user) {
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        return user;
    }
}
