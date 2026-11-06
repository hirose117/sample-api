package com.example.sampleapi.repository;

import com.example.sampleapi.dto.User;
import com.example.sampleapi.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final UserMapper userMapper;

    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
