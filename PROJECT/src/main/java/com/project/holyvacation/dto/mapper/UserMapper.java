package com.project.holyvacation.dto.mapper;

import com.project.holyvacation.domain.User;
import com.project.holyvacation.dto.UserDTO;

public interface UserMapper {
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
    User updateEntity(UserDTO userDTO, User user);
}
