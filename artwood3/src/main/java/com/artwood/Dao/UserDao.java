package com.artwood.Dao;

import com.artwood.model.User;

public interface UserDao {
    void addUser(User user);
    User getUser(int id);


    void deletUser(int id);

    void updateUser(int id,User userUpdated);
}

// Implementation
