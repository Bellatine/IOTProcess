package com.namng.repository;

import com.namng.model.User;

import java.util.List;

public interface UserRepository {
    List<User>LoadAllUser();
    void save(User user);
}
