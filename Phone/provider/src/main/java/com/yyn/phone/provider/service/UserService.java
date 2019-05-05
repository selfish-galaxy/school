package com.yyn.phone.provider.service;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.User;

import java.util.List;

public interface UserService {

    List<User> showAllUsers();

    PageBean<User> showAll(Integer page, Integer size);

    void addUser(User user);

    void delUser(Integer id);

    User selectOneUser(Integer id);

    void updateUser(User user);
}
