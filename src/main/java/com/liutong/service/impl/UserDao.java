package com.liutong.service.impl;

import com.liutong.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

  @Insert("INSERT INTO user (username,password) VALUES (#{username},#{password})")
  int addUser(User user);
}
