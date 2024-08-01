package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dao.entity.RoleEntity;
import com.example.schoolmanagement.dao.repository.UserRepository;
import com.example.schoolmanagement.maper.UserMapper;
import com.example.schoolmanagement.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void register(UserDto user) {
        var userEntity = userMapper.toUserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        var roleEntity = new RoleEntity(null, "ROLE_USER", userEntity);
        userEntity.setRoles(List.of(roleEntity));
        userRepository.save(userEntity);
    }
}
