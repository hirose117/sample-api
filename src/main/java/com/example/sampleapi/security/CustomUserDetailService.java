package com.example.sampleapi.security;

import com.example.sampleapi.dto.User;
import com.example.sampleapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // DBからデータを取得
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.selectUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
}
