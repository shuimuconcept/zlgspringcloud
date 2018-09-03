package com.example.servicebatch.service;


import com.example.servicebatch.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    List<User> findAllUser(int pageNum, int pageSize);
    int deleteUser(int id);
    User findUserByid(int id);
}
