package com.namng.service;

import com.namng.model.User;
import com.namng.object.SigninRequest;
import com.namng.object.SignupRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService {
    public boolean checkUser(SigninRequest signinRequest);

    public void saveUser(SignupRequest signupRequest);
}
