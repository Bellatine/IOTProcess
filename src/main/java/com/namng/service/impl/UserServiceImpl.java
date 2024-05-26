package com.namng.service.impl;

import com.namng.model.User;
import com.namng.object.SigninRequest;
import com.namng.object.SignupRequest;
import com.namng.repository.Impl.UserRepositoryImpl;
import com.namng.repository.UserRepository;
import com.namng.service.UserService;
import com.namng.util.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {
    @Autowired
    private UserRepository userRepository = new UserRepositoryImpl();
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = CacheManager.Users.ALLUSERS.get(userName);
        if (user == null || user.getStatus() == 0) {
            throw new UsernameNotFoundException("User not found or inactive!");
        }
        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(userName);
        builder.password(user.getPassWord());
        if(user.getRole() == CacheManager.Role.ADMIN){
            builder.roles("ADMIN");
        } else if (user.getRole() == CacheManager.Role.VIEWER) {
            builder.roles("USER");
        }
        CacheManager.Users.AUTH_USER = user;
        return builder.build();
    }


    @Override
    public boolean checkUser(SigninRequest signinRequest) {
        return false;
    }

    @Override
    public void saveUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUserName(signupRequest.getUserName());
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        user.setFullName(signupRequest.getFullName());
        user.setRole(signupRequest.getRole());
        user.setStatus(CacheManager.Status.ACTIVE);
        userRepository.save(user);
    }
}
