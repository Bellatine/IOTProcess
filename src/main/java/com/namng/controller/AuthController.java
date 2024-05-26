package com.namng.controller;

import com.namng.object.DeviceInforRequest;
import com.namng.object.SigninRequest;
import com.namng.object.SignupRequest;
import com.namng.service.UserService;
import com.namng.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/iot/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private UserService userService = new UserServiceImpl();

    @PostMapping("/signin")
    public ResponseEntity<?> SignIn(@RequestBody SigninRequest signinRequest){

        return ResponseEntity.ok("Signin success!");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> SignUp(@RequestBody SignupRequest signupRequest){

        return ResponseEntity.ok(("Signup success"));
    }



}
