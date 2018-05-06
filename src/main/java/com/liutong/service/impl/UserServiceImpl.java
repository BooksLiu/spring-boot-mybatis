package com.liutong.service.impl;

import com.liutong.model.User;
import com.liutong.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  @Resource
  UserDao userDao;

  @Override
  public boolean addUser(User user) {
    return userDao.addUser(user) > 0;
  }
}
