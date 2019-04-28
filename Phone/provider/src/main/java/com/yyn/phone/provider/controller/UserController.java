package com.yyn.phone.provider.controller;

import com.yyn.phone.provider.pojo.PageBean;
import com.yyn.phone.provider.pojo.User;
import com.yyn.phone.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public List<User> showAllUsers(){
        return userService.showAllUsers();
    }

    @RequestMapping("/addUser")
    public void addUser(User user){
        userService.addUser(user);
    }

    @RequestMapping("/delUser")
    public void delUser(Integer id){
        userService.delUser(id);
    }

    @RequestMapping("/selectOneUser")
    public User selectOneUser(Integer id){
        return userService.selectOneUser(id);
    }

    @RequestMapping("/updateUser")
    public void updateUser(User user){
        userService.updateUser(user);
    }

    @RequestMapping("/pageUser")
    public PageBean<User> userPage(Integer page, Integer size){
        return userService.showAll(page, size);
    }
}
