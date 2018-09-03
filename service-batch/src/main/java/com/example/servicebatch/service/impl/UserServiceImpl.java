package com.example.servicebatch.service.impl;

import com.example.servicebatch.mapper.UserMapper;
import com.example.servicebatch.model.User;
import com.example.servicebatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    ExecutorService pool = Executors.newFixedThreadPool(2);

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        return userMapper.selectAllUser();
    }

    @Transactional
    @Override
    public int deleteUser(int id) {
        int c = userMapper.delete(id + 1);
        return c;
    }

    @Override
    public User findUserByid(int id) {
        return userMapper.selectByPrimaryKey(id);
    }


}
